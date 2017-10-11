<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::pattern('id', '[0-9]+');

Route::post('auth/token', 'Restful\TokenController@authenticateByPassword');
Route::post('auth/refresh', 'Restful\TokenController@refreshToken');