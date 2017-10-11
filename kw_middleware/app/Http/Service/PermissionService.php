<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use Illuminate\Http\Request;

/**
 * @author Jeff So
 * @file PermissionService.phpce.php
 * @package App\Service
 * @brief Role 관련된 Service
 */
interface PermissionService
{
    /**
     * Get Role All List.
     *
     * @return Role Model Object
     */
    public function getRoleAllList();

    /**
     * Get Role data Total Count.
     *
     * @return int
     */
    public function getRoleTotalCount();

    /**
     * Get Role data By Role ID.
     *
     * @param $roleId
     * @return Role Model Object
     */
    public function getRoleById($roleId);

    /**
     * Add Role with Permission.
     *
     * @param Request $request
     * @return bool true|false
     */
    public function addRoleWithPermission(Request $request);

    /**
     * Edit Role With Permission.
     *
     * @param Request $request
     * @return bool true|false
     */
    public function editRoleWithPermission(Request $request);

    /**
     * Set Role Delete By Role Id.
     *
     * @param int $roleId
     * @return bool true|false
     */
    public function setRoleDeleteByRoleId($roleId);

    /**
     * Get Permission All List.
     *
     * @return Permission Model Object
     */
    public function getPermissionAllList();

    /**
     * Get Permission data Total Count.
     *
     * @return int
     */
    public function getPermissionTotalCount();
}