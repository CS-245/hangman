<!DOCTYPE html>
<html lang="{{ config('app.locale') }}">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>KW Middleware | Login</title>

    <link href="{{ asset('vendor/bootstrap/css/bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/font-awesome/css/font-awesome.css') }}" rel="stylesheet">

    <!-- Sweet Alert -->
    <link href="{{ asset('vendor/sweetalert/css/sweetalert2.min.css') }}" rel="stylesheet">

    <link href="{{ asset('css/animate.css') }}" rel="stylesheet">
    <link href="{{ asset('css/admin-style.css') }}" rel="stylesheet">

    <script>
        window.Laravel = {!! json_encode([
            'csrfToken' => csrf_token(),
        ]) !!};
    </script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">KW</h1>
        </div>
        <h3>Welcome to KW EDI</h3>
        <form class="m-t" method="POST" role="form" action="{{ route('login') }}">
            {{ csrf_field() }}
            <input type="hidden" id="warning" value="{{ Session::get('warning') }}"/>
            <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                <input type="email" name="email" class="form-control" placeholder="Username" {{ old('email') }} required="">
                @if ($errors->has('email'))
                    <span class="help-block">
                        <strong>{{ $errors->first('email') }}</strong>
                    </span>
                @endif
            </div>
            <div class="form-group {{ $errors->has('email') ? ' has-error' : '' }}">
                <input type="password" name="password" class="form-control" placeholder="Password" required="">
            </div>

            <div class="form-group">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember" {{ old('remember') ? 'checked' : '' }}> Remember Me
                    </label>
                </div>
            </div>

            <button type="submit" class="btn btn-success block full-width m-b">Login</button>

            <a href="{{ route('password.request') }}">
                <small>Forgot password?</small>
            </a>
            <p class="text-muted text-center"><small>Do not have an account?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="{{ route('register') }}">Create an account</a>
            {{--<a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>--}}
        </form>
        <p class="m-t">
            <small></small>
        </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="{{ asset('vendor/jquery/js/jquery-3.2.1.min.js') }}"></script>
<script src="{{ asset('vendor/bootstrap/js/bootstrap.min.js') }}"></script>

<!-- Sweet alert -->
<script src="{{ asset('vendor/sweetalert/js/sweetalert2.min.js') }}"></script>

<script src="{{ asset('js/app-common.js') }}"></script>

<script>
    $(document).ready(function () {
        if ($('#warning').val().length != 0) {
            show_message('User Activation',
                $('#warning').val(),
                'error',
                'OK'
            );
        }
    });
</script>

</body>

</html>
