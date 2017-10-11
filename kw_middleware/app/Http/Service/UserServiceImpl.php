<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Spatie\Permission\Models\Role;
use Support\DataTableSupportImpl as DataTableSupport;
use Maatwebsite\Excel\Facades\Excel;


/**
 * @author Jeff So
 * @file UserServiceImpl.php
 * @package App\Service
 * @brief UserService 구현 부분.
 */

class UserServiceImpl implements UserService
{
    /**
     * Get UserModel All List.
     *
     * @return User Model Object
     */
    public function getUserAllList()
    {
        return User::all();
    }

    /**
     * Get User Data By User ID.
     *
     * @param int $userId
     * @return User Model Object
     */
    public function getUserByUserId($userId)
    {
        return User::find($userId);
    }

    /**
     * Get User Total Count.
     *
     * @return int
     */
    public function getUserTotalCount()
    {
        return User::all()->count();
    }

    /**
     * Set User Delete By User ID.
     *
     * @param int $userId
     * @param string $deleteFlag
     * @return bool true|false
     */
    public function setUserDeleteByUserId($userId, $deleteFlag)
    {
        try {
            $user = User::find($userId);
            $user->del_yn = $deleteFlag;

            $user->save();
        } catch (\Exception $exception) {
            return false;
        }

        return true;
    }

    /**
     * Set User Activation By User ID
     * @param int $userId
     * @param string $activateFlag
     * @return bool true|false
     */
    public function setUserActivationByUserId($userId, $activateFlag)
    {
        try {
            $user = User::find($userId);
            $user->activate_yn = $activateFlag;

            $user->save();
        } catch (\Exception $exception) {
            return false;
        }

        return true;
    }

    /**
     * Add User With Role
     *
     * @param Request $request User Form Request
     * @return bool true|false
     */
    public function addUserWithRole(Request $request)
    {
        $result = DB::transaction(function() use ($request) {
                try {
                    
                    $user = User::create([
                        'first_name' => $request['first_name'],
                        'last_name' => $request['last_name'],
                        'email' => $request['email'],
                        'cell_phone' => $request['cell_phone'],
                        'password' => bcrypt($request['password']),
                    ]);

                    $user->assignRole(Role::find($request['auth']));

                    return true;
                } catch (\Exception $exception) {
                    return false;
                }
            });

        return $result;
    }

    /**
     * Edit User With Role
     *
     * @param Request $request
     * @return bool true|false
     */
    public function editUserWithRole(Request $request)
    {
        $result = DB::transaction(function() use ($request) {
                try {
                    $user = User::find($request['user_id']);
                    $user->first_name = $request['first_name'];
                    $user->last_name = $request['last_name'];
                    $user->cell_phone = $request['cell_phone'];
                    $user->activate_yn = $request['activate_yn'];

                    if (!empty($request['password'])) {
                        $user->password = bcrypt($request['password']);;
                    }

                    $user->syncRoles(Role::find($request['auth']));
                    $user->save();

                    return true;
                } catch (\Exception $exception) {
                    return false;
                }
            });

        return $result;
    }

    /**
     * Make Datatable Json Array for user list.
     *
     * @param Request $request Datatable Request Data.
     * @return Json Array
     */
    public function makeDatatableUserList(Request $request)
    {
        $dataList = DB::transaction(function () use ($request) {
            // Step 1. Define Sort Column
            $reqSortDir = $request['order'][0]['dir'];
            $reqSortColumnKey = $request['columns'][$request['order'][0]['column']]['data'];

            $columns = array(
                'name' => 'first_name '. $reqSortDir .', last_name',
                'email' => 'email',
                'auth' => 'name',
                'activate_yn' => 'activate_yn',
                'del_yn' => 'del_yn',
                'create_date' => 'created_at'
            );

            // Step 2. Get Data Query
            $userList = User::skip($request['start'])
                ->take($request['length'])
                ->get();

            // Step 3. Make Data List
            $listNum = $request['start'];
            $listArray = array();

            foreach($userList as $user) {
                $roleName = '';
                foreach ($user->roles as $role) {
                    print_r($role->name);
                    if(empty($roleName)) {
                        $roleName = $role->name;
                    } else {
                        $roleName .= ', ' . $role->name;
                    }
                }

                $data = array(
                    'no' => ($listNum + 1),
                    'name' => $user->getFullName(),
                    'email' => $user->email,
                    'auth' => $roleName,
                    'activate_yn' => ($user->activate_yn == 'Y' ? 'Yes' : 'No'),
                    'del_yn' => ($user->del_yn == 'Y' ? 'Yes' : 'No'),
                    'create_date' => $user->created_at->format('m/d/y H:i:s')
                );

                array_push($listArray, $data);

                $listNum++;
            }

            return $listArray;
        });

        print_r($dataList);

        $dataTotalCount = $this->getUserTotalCount();
    }    
}