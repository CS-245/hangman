<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Controllers\Restful;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Route;

/**
 * @author Jeff So
 * @file TokenController.php
 * @package App\Http\Controllers\Restful
 * @brief Restful TotkcenController \n
 * Token 관련 데이터 처리 Controller.
 */
class TokenController extends Controller
{
    /**
     * Token DB Data.
     *
     * @var object $client
     */
    private $client;

    /**
     * DefaultController constructor.
     */
    public function __construct()
    {
        // Get grant type : password...
        $this->client = DB::table('oauth_clients')->where('id', 2)->first();
    }

    /**
     * Token authenticate By Password
     *
     * @param Request $request
     * @return mixed
     */
    protected function authenticateByPassword(Request $request)
    {
        $request->request->add([
            'username' => $request->username,
            'password' => $request->password,
            'grant_type' => 'password',
            'client_id' => $this->client->id,
            'client_secret' => $this->client->secret,
            'scope' => '*'
        ]);

        $proxy = Request::create(
            'oauth/token',
            'POST'
        );

        return Route::dispatch($proxy);
    }

    /**
     * Token Refresh
     *
     * @param Request $request
     * @return mixed
     */
    protected function refreshToken(Request $request)
    {
        $request->request->add([
            'grant_type' => 'refresh_token',
            'refresh_token' => $request->refresh_token,
            'client_id' => $this->client->id,
            'client_secret' => $this->client->secret,
        ]);

        $proxy = Request::create(
            '/oauth/token',
            'POST'
        );

        return Route::dispatch($proxy);
    }
}
