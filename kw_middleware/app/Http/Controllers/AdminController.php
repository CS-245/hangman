<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session; 
use Maatwebsite\Excel\Facades\Excel;
use App\Service\UserServiceImpl as UserService;
use App\Service\PermissionServiceImpl as PermissionService;
use App\Service\ReportServiceImpl as ReportService;

/**
 * @author Jeff So
 * @file AdminController.php
 * @package App\Http\Controllers
 * @brief AdminController \n
 * Admin에서 들어오는 Request를 처리하는 Controller.
 */
class AdminController extends Controller
{
    public function __construct()
    {
        if(!Auth::check()) {
            return redirect(route('login'));
        }
    }

    /**
     * Show the application admin dashboard.
     *
     * @return view
     */
    public function index() {
        return view('admin.index');
    }

    /**
     * User Register Processing
     *
     * @param Request $request
     * @return redirect to User List View
     */
    protected function userRegisterProcessing(Request $request) {

        $this->validate($request, [
            'first_name' => 'required|string|max:255',
            'last_name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:kw_user',
            'cell_phone' => 'required|string|max:255',
            'password' => 'required|string|min:6|confirmed',
            'auth' => 'required|array|min:1'
        ]);

        $userService = new UserService();
        $userService->addUserWithRole($request);

        return redirect('/admin/user/list');
    }

    /**
     * User Edit Processing.
     *
     * @param Request $request
     * @return redirect to User List View
     */
    protected function userEditProcessing(Request $request) {

        $validateRule = [
            'first_name' => 'required|string|max:255',
            'last_name' => 'required|string|max:255',
            'cell_phone' => 'required|string|max:255',
            'auth' => 'required|array|min:1'
        ];

        $validateRule = !empty($request['password'])
            ? array_merge($validateRule, array('password' => 'required|string|min:6|confirmed')) : $validateRule;

        $this->validate($request, $validateRule);

        $userService = new UserService();
        $userService->editUserWithRole($request);

        return redirect('/admin/user/list');
    }

    /**
     * User Uploading Processing
     *
     * @param Request $request
     * @return result_msg
     */
    protected function userUploadProcessing(Request $request) {
        $result_msg = "1";
        $reader = Excel::load($request->file('uploaded_file')->getPathname());
        $reader->each(function($sheets)
        {
            
            $sheets->skipRows(1);
           
            $sheets->each(function($row_data)
            {
                $row = json_decode($row_data, true);
                if(isset($row['no'])) {
                    $name_parts = explode(' ', $row['name']);
                    $first_name = "";
                    for($i = 0; $i < count($name_parts) - 1; ++$i) {
                        if($i == 0) {
                            $first_name .= $name_parts[$i];
                        }
                        else {
                            $first_name .= " " . $name_parts[$i];
                        }
                    }
                    try {
                        $user = User::find(intval($row['no']));
                        $user->first_name = $first_name;
                        $user->last_name = $name_parts[count($name_parts)-1];
                        $user->cell_phone = "1234567890";
                        if($row['activation'] = "Yes") {
                            $user->activate_yn = "y";
                        }
                        else {
                            $user->activate_yn = "n";
                        }
                        $user->password = bcrypt('123456');
                        $user->save();
                    } catch (Exception $exception) {
                        if($row['activation'] = "Yes") {
                            $activate_yn = "y";
                        }
                        else {
                            $activate_yn = "n";
                        }
                        $user = User::create([
                            'first_name' => $first_name,
                            'last_name' => $name_parts[count($name_parts)-1],
                            'email' => $row['email'],
                            'cell_phone' => '1234567890',
                            'activate_yn' => $activate_yn,
                            'password' => bcrypt('123456')
                        ]);
                    }
                }
            });
            
        });
        return $result_msg;
    }
    
    /**
     * Role Register Processing
     *
     * @param Request $request
     * @return redirect Role List
     */
    protected function roleRegisterProcessing(Request $request) {
        $this->validate($request, [
            'name' => 'required|string|max:255|unique:'.config('permission.table_names.roles'),
        ]);

        $permissionService = new PermissionService();
        $permissionService->addRoleWithPermission($request);

        return redirect('/admin/role/list');
    }

    /**
     * Role Edit Processing
     *
     * @param Request $request
     * @return redirect Role List
     */
    protected function roleEditProcessing(Request $request) {

        $this->validate($request, [
            'name' => 'required|string|max:255|unique:'
                . config('permission.table_names.roles') .',NULL,'.$request['role_id'].',id',
        ]);

        $permissionService = new PermissionService();
        $permissionService->editRoleWithPermission($request);

        return redirect('/admin/role/list');
    }
    
    /**
     * Save Nav-bar State
     *
     * @param Request $request
     * @body save the state of 'show' key
     */
    protected function savedNavBarState(Request $request){
        Session::put('show', $request['show']);
    }
}
