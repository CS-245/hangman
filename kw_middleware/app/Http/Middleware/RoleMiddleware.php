<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;
use Spatie\Permission\Models\Role;
/**
 * @author Jeff So
 * @file RoleMiddleware.php
 * @package App\Http\Middleware
 * @brief \Spatie\Permission\Middlewares\RoleMiddleware::class Modify
 */
class RoleMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next, $role = null, $permission = null)
    {
        if (Auth::guest()) {
            if($request->is('admin') || $request->is('admin/*')) {
                return redirect('/login');
            } else {
                return redirect('/');
            }
        }

        if($role != null) {
            if (!$request->user()->hasAnyRole(explode("|", $role))) {
                abort(403, 'Unauthorized action.');
            }
        }

        if($permission != null) {
            if (! $request->user()->can($permission)) {
                abort(403, 'Unauthorized action.');
            }
        }

        return $next($request);
    }
}
