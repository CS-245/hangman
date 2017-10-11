<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Controllers\Restful;

use App\Service\PermissionServiceImpl;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Service\PermissionServiceImpl as PermissionService;

/**
 * @author Jeff So
 * @file PermissionController.php
 * @package App\Http\Controllers\Restful
 * @brief Restful PermissionController \n
 * Role or Permission 관련 Request 처리 Controller.
 */
class PermissionController extends Controller
{
    /**
     * Permission Service
     *
     * @var PermissionService $permissionService
     */
    private $permissionService;

    public function __construct()
    {
        $this->permissionService = new PermissionService();
    }

    /**
     * Setting Role Delete or Active
     *
     * @param Request $request
     * @return Json Array
     */
    protected function roleActiveProcessing(Request $request) {

        $roleId = $request['role_id'];

        if($this->permissionService->setRoleDeleteByRoleId($roleId)) {
            $response = array('error' => false,
                'status_code' => 200);
        } else {
            $response = array('error' => true,
                'status_code' => 0,
                'message' => 'Fail Role Delete');
        }

        return $response;
    }
}
