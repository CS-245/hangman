<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::pattern('id', '[0-9]+');

Route::get('/', function (Request $request) {
    return redirect('/login');
});

Route::get('users', 'UserController@index');

Route::get('items', 'ItemController@index');
Route::post('items/import', 'ItemController@import');
Route::get('items/export', 'ItemController@export');

Route::get('po', 'POController@index');
Route::post('po/import', 'POController@import');
Route::get('po/export', 'POController@export');


Auth::routes();
