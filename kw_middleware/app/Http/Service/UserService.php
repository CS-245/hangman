<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use Illuminate\Http\Request;

/**
 * @author Jeff So
 * @file UserService.php
 * @package App\Service
 * @brief User에 관련된 Service
 */
interface UserService
{
    /**
     * Get User All List.
     *
     * @return User Model Object
     */
    public function getUserAllList();

    /**
     * Get User Data By User ID.
     *
     * @param int $userId
     * @return User Model Object
     */
    public function getUserByUserId($userId);

    /**
     * Get User Total Count.
     *
     * @return int
     */
    public function getUserTotalCount();

    /**
     * Set User Delete By User ID
     *
     * @param int $userId
     * @param string $deleteFlag
     * @return bool true|false
     */
    public function setUserDeleteByUserId($userId, $deleteFlag);

    /**
     * Set User Activation By User ID
     * @param int $userId
     * @param string $activateFlag
     * @return bool true|false
     */
    public function setUserActivationByUserId($userId, $activateFlag);

    /**
     * Add User With Role
     *
     * @param Request $request User Form Request
     * @return bool true|false
     */
    public function addUserWithRole(Request $request);

    /**
     * Edit User With Role
     *
     * @param Request $request
     * @return bool true|false
     */
    public function editUserWithRole(Request $request);

    /**
     * Make Datatable Json Array for user list.
     *
     * @param Request $request Datatable Request Data.
     * @return Json Array
     */
    public function makeDatatableUserList(Request $request);
}