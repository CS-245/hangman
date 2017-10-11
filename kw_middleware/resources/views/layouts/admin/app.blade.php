<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>KW Middleware | Admin</title>

    <link href="{{ asset('vendor/bootstrap/css/bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/font-awesome/css/font-awesome.css') }}" rel="stylesheet">

    <!-- Toastr style -->
    <link href="{{ asset('vendor/toastr/css/toastr.min.css') }}" rel="stylesheet">

    <!-- Gritter -->
    <link href="{{ asset('vendor/gritter/css/jquery.gritter.css') }}" rel="stylesheet">

    <!-- Sweet Alert -->
    <link href="{{ asset('vendor/sweetalert/css/sweetalert2.min.css') }}" rel="stylesheet">

    <link href="{{ asset('css/animate.css') }}" rel="stylesheet">
    <link href="{{ asset('css/admin-style.css') }}" rel="stylesheet">

    @yield('header')

    <script>
        window.Laravel = {!! json_encode([
            'csrfToken' => csrf_token(),
        ]) !!};
    </script>
</head>

<input type="hidden" id="side" data-show-link="{{ url('/admin/savedNavBarState') }}"></input>

<!-- laravel php code to see if 'show' is true -->
<!-- put mini-navbar in class if 'show is true' -->

<body class="

@if(	Session::get('show'))
    mini-navbar
@endif

">

<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            @include('layouts.admin.sidemenu')
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
<!--                 here is where we create the toggle id -->
                    <a id="toggle-Nav-Bar" class="navbar-minimalize minimalize-styl-2 btn btn-success" href="#"><i class="fa fa-bars"></i> </a>
                    {{--<form role="search" class="navbar-form-custom" action="search_results.html">--}}
                        {{--<div class="form-group">--}}
                            {{--<input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">--}}
                        {{--</div>--}}
                    {{--</form>--}}
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">Welcome {{ Auth::user()->getFullName() }}.</span>
                    </li>
                    <li>
                        <a href="{{ route('logout') }}" onclick="event.preventDefault(); document.getElementById('logout-form').submit();" >
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                        <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                            {{ csrf_field() }}
                        </form>
                    </li>
                </ul>
            </nav>
        </div>

        @yield('content')

        <div class="footer">
            <div class="pull-right">
                <strong>KW Middeware</strong>
            </div>
            <div>
                <strong>Copyright</strong> KWI &lt;<a href="http://www.kwinternational.com">http://www.kwinternational.com</a>&gt;
            </div>
        </div>
    </div>
</div>

<!-- Mainly scripts -->
<script src="{{ asset('vendor/jquery/js/jquery-3.2.1.min.js') }}"></script>
<script src="{{ asset('vendor/bootstrap/js/bootstrap.min.js') }}"></script>
<script src="{{ asset('vendor/metis-menu/js/jquery.metis-menu.js') }}"></script>
<script src="{{ asset('vendor/slimscroll/js/jquery.slimscroll.min.js') }}"></script>

<!-- Custom and plugin javascript -->
<script src="{{ asset('vendor/inspinia/js/inspinia.js') }}"></script>
<script src="{{ asset('vendor/pace/js/pace.min.js') }}"></script>

<!-- GITTER -->
<script src="{{ asset('vendor/gritter/js/jquery.gritter.min.js') }}"></script>

<!-- Toastr -->
<script src="{{ asset('vendor/toastr/js/toastr.min.js') }}"></script>

<!-- Sweet alert -->
<script src="{{ asset('vendor/sweetalert/js/sweetalert2.min.js') }}"></script>

<script src="{{ asset('js/app-common.js') }}"></script>
@yield('after-script')

<script>
	
    $(document).ready(function() {
        
    		$( "#toggle-Nav-Bar" ).on( "click", function() {
        		savedNavBarState();
    		});
    });

    /**
     * Show if the mini-navbar is being used 
     * @function show
     * 
     */
	function savedNavBarState() {	
	    var url = $('#side').data('show-link');
	    $.ajax({    
		    type: 'POST',
		    url: url,
		    headers: {
		        'X-Requested-With': 'XMLHttpRequest',
		        'X-CSRF-TOKEN' : $('meta[name="csrf-token"]').attr('content')
		    },		    
		    data: JSON.stringify({'show':$('body').hasClass('mini-navbar')}),
		    dataType: 'json',
			cache: false,
			contentType: 'application/json',
			processData: false,
		    success: function(data) {
		    	},
		    	fail:function(error) {
			    	alert('error');
		    	}
		});
	}
</script>
</body>
</html>