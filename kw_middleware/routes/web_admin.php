<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
use App\Service\ReportServiceImpl;
use Illuminate\Http\Request;
use App\Service\UserServiceImpl as UserService;
use App\Service\ReportServiceImpl as ReportService;
use App\Service\PermissionServiceImpl as PermissionService;
/*
|--------------------------------------------------------------------------
| Web Admin Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::pattern('id', '[0-9]+');

Route::get('/admin', ['middleware' => ['role:super-admin|admin|user'], 'uses' => 'AdminController@index']);
Route::post('/admin/savedNavBarState', ['middleware' => ['auth'], 'uses' => 'AdminController@savedNavBarState']);

Route::group(['prefix' => 'admin/user', 'middleware' => ['role:super-admin|admin']], function() {
    Route::get('/list', function() {
        $userService = new UserService();
        return view('admin.setting.user.list', array('users' => $userService->getUserAllList()));
    });

    Route::get('/register', function() {
        $permissionService = new PermissionService();
        return view('admin.setting.user.form', ['view_type' => 'Create',
            'roles' => $permissionService->getRoleAllList()]);
    });

    Route::get('/edit/{id}', function(Request $request, $id) {
        $userService = new UserService();
        $permissionService = new PermissionService();

        return view('admin.setting.user.form', ['view_type' => 'Update',
            'user' => $userService->getUserByUserId($id),
            'roles' => $permissionService->getRoleAllList()
        ]);
    });
    
    Route::post('/upload', 'AdminController@userUploadProcessing');
    Route::post('/register-processing', 'AdminController@userRegisterProcessing');
    Route::post('/edit-processing', 'AdminController@userEditProcessing');
});

Route::group(['prefix' => 'admin/reports', 'middleware' => ['role:super-admin|admin']], function() {
    
    Route::get('/pie-chart', function(Request $request){
        $userService = new UserService();
        return view('admin.setting.user.pie-chart');
    }); 
    
    Route::get('/items', function(Request $request){
        $userService = new UserService();
        $reportService = new ReportService();
        return view('admin.setting.user.items', compact('items', 'item'));
    });   
});

Route::group(['prefix' => 'admin/role', 'middleware' => ['role:super-admin|admin']], function() {
    Route::get('/list', function() {
        $permissionService = new PermissionService();
        return view('admin.setting.role.list', array('roles' => $permissionService->getRoleAllList()));
    });

    Route::get('/register', function() {
        $permissionService = new PermissionService();
        return view('admin.setting.role.form', ['view_type' => 'Create',
            'permissions' => $permissionService->getPermissionAllList()]);
    });

    Route::get('/edit/{id}', function(Request $request, $id) {
        $permissionService = new PermissionService();

        return view('admin.setting.role.form', ['view_type' => 'Update',
            'role' => $permissionService->getRoleById($id),
            'permissions' => $permissionService->getPermissionAllList()
        ]);
    });
    
    Route::post('/register-processing', 'AdminController@roleRegisterProcessing');
    Route::post('/edit-processing', 'AdminController@roleEditProcessing'); 
    
});