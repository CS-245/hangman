<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
use App\Service\UserServiceImpl;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API V1 Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::pattern('id', '[0-9]+');

Route::group(['prefix' => 'v1/user', 'middleware' => ['auth:api']], function() {
    Route::post('/active', 'Restful\UserController@userActiveProcessing');
    Route::post('/datatable/list', 'Restful\UserController@getUserDatatableList');
});

Route::group(['prefix' => 'v1/role', 'middleware' => ['auth:api']], function() {
    Route::post('/active', 'Restful\PermissionController@roleActiveProcessing');
});

Route::group(['prefix' => 'v1/reports', 'middleware' => ['auth:api']], function() {
    Route::post('/refresh', 'Restful\UserController@refresh');
//     Route::post('/items', 'Restful\ItemController@index', compact('items', 'item'));
    Route::post('/import', 'Restful\ItemController@import');
    Route::post('/export', 'Restful\ItemController@export');
});