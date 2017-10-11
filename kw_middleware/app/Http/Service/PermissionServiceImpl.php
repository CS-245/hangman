<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Spatie\Permission\Models\Permission;
use Spatie\Permission\Models\Role;

/**
 * @author Jeff So
 * @file PermissionServiceImpl.php
 * @package App\Service
 * @brief PermissionService 구현 부분.
 */
class PermissionServiceImpl implements PermissionService
{

    /**
     * Get Role All List.
     *
     * @return Role Model Object
     */
    public function getRoleAllList()
    {
        return Role::all();
    }

    /**
     * Get Role Total Count
     *
     * @return int
     */
    public function getRoleTotalCount()
    {
        return Role::all()->count();
    }

    /**
     * Get Role data By Role ID.
     *
     * @param $roleId
     * @return Role Model Object
     */
    public function getRoleById($roleId)
    {
        return Role::find($roleId);
    }

    /**
     * Get Permission All List.
     *
     * @return Permission Model Object
     */
    public function getPermissionAllList()
    {
        return Permission::all();
    }

    /**
     * Get Permission data Total Count.
     *
     * @return int
     */
    public function getPermissionTotalCount()
    {
        return Permission::all()->count();
    }

    /**
     * Add Role with Permission
     *
     * @param Request $request
     * @return bool true|false
     */
    public function addRoleWithPermission(Request $request)
    {
        $result = DB::transaction(function() use($request) {
            try {
                $role = Role::create(['name' => $request['name']]);

                if(!empty($request['permission'])) {
                    $role->givePermissionTo(Permission::find($request['permission']));
                }

                return true;
            } catch (\Exception $exception) {
                return false;
            }
        });

        return $result;
    }

    /**
     * Edit Role With Permission.
     *
     * @param Request $request
     * @return bool true|false
     */
    public function editRoleWithPermission(Request $request)
    {
        $result = DB::transaction(function() use($request) {
            try {
                $role = Role::find($request['role_id']);
                $role->name = $request['name'];

                $role->syncPermissions(Permission::find($request['permission']));
                $role->save();

                return true;
            } catch(\Exception $exception) {
                return false;
            }
        });

        return $result;
    }

    /**
     * Set Role Delete By Role Id
     *
     * @param int $roleId
     * @return bool true|false
     */
    public function setRoleDeleteByRoleId($roleId)
    {
        $result = DB::transaction(function() use($roleId) {
            try {
                // Step 1. Find Role By Role ID
                $role = Role::find($roleId);
                // Step 2. * Permissions Detach By Role.
                //         * Users Detach By Role.
                $role->permissions()->detach();
                $users = $role->users();
                $users->detach();

                // Step 3. Delete Role.
                $role->delete();

                return true;
            } catch(\Exception $exception) {
                return false;
            }
        });

        return $result;
    }
}