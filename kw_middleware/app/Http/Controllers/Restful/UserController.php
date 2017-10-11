<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Controllers\Restful;

use App\Service\UserServiceImpl as UserService;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Service\ReportServiceImpl as ReportService;

/**
 * @author Jeff So
 * @file UserController.php
 * @package App\Http\Controllers\Restful
 * @brief Restful UserController \n
 * User 관련 Request 처리 Controller.
 */
class UserController extends Controller
{
    
    /**
     * User Service
     *
     * @var UserService $userService
     */
    private $userService;

    public function __construct()
    {
        $this->userService = new UserService();
    }

    /**
     * Get User Datatable List.
     *
     * @param Request $request
     * @return Json Array for Datatable
     */
    protected function getUserDatatableList(Request $request) {
        return $this->userService->makeDatatableUserList($request);
    }

    /**
     * Setting User Delete or Active
     *
     * @param Request $request
     * @return Json Array
     */
    protected function userActiveProcessing(Request $request) {

        $actionType = $request['action_type'];
        $actionFlag = $request['action_flag'];
        $userId = $request['user_id'];

        if($actionType == 'Delete') {
            $result = $this->userService->setUserDeleteByUserId($userId, $actionFlag);
        } else {
            $result = $this->userService->setUserActivationByUserId($userId, $actionFlag);
        }

        if($result) {
            $response = array('error' => false,
                'status_code' => 200);
        } else {
            $response = array('error' => true,
                'status_code' => 0);
        }

        return $response;
    }
    
    /**
     * Refresh
     *
     * @param Request $request
     * @return json code of number of deleted, activated, non-activated
     */
    protected function refresh(Request $request){
        
        $reportService = new ReportService();
        
        return $reportService->refresh($request);
    }
    
    protected function savedNavBarState(Request $request){
        
        $userService = new UserService();
        return $userService->savedNavBarState($request);
        
    }
    
}
