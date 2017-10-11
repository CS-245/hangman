<ul class="nav metismenu" id="side-menu">
    <li class="nav-header">
        <div class="dropdown profile-element"> <span>
            	<img alt="image" class="img-circle" src="{{ asset('images/kwlogo.jpg') }}"/>
                             </span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong
                                            class="font-bold">{{ Auth::user()->getFullName() }}</strong>
                             </span> <span class="text-muted text-xs block">{{ Auth::user()->roles->first()->name }}<b
                       class="caret"></b></span> </span> </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                <li class="divider"></li>
                <li><a href="{{ route('logout') }}" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Logout</a></li>
            </ul>
        </div>
        <div class="logo-element">
            KW
        </div>
    </li>
    <li class="{{ request()->is('admin') ? 'active' : '' }}">
        <a href="{{ url('/admin') }}"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span></a>
    </li>
    {{--<li class="{{request()->is('admin/page/*') ? 'active' : ''}}">--}}
        {{--<a href="#"><i class="fa fa-list"></i> <span class="nav-label">Page Management</span><span--}}
            {{--class="fa arrow"></span></a>--}}
        {{--<ul class="nav nav-second-level collapse">--}}
            {{--<li class="{{request()->is('admin/page/*') ? 'active' : ''}}"><a href="{{url('/admin/page/list')}}">PageModel List</a></li>--}}
        {{--</ul>--}}
    {{--</li>--}}
    @if(Auth::user()->hasRole('super-admin') || Auth::user()->hasRole('admin'))
        <li class="{{request()->is('admin/theme/*') ? 'active' : ''}}">
            <a href="#"><i class="fa fa-image"></i> <span class="nav-label">Theme Management</span><span
                        class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
            </ul>
        </li>
        
        <li class="{{request()->is(['admin/user/*', 'admin/role/*', 'admin/permission/*', 'admin/theme/*']) ? 'active' : ''}}">
            <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">Setting </span><span
                        class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                <li class="{{request()->is('admin/user/*') ? 'active' : ''}}">
                    <a href="#"><i class="fa fa-user"></i> User Management
                        <span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level collapse">
                        <li class=" {{request()->is('admin/user/*') ? 'active' : '' }}"><a href="{{ url('/admin/user/list') }}">User List</a></li>
                    </ul>
                </li>

                <li class="{{ request()->is(['admin/role/*', 'admin/permission/*']) ? 'active' : '' }}">
                    <a href="#"><i class="fa fa-user-secret"></i> Role Management
                        <span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level collapse">
                        <li class="{{ request()->is('admin/role/*') ? 'active' : '' }}"><a href="{{url('/admin/role/list')}}">Role List</a></li>
                        <li class="{{ request()->is('admin/permission/*') ? 'active' : '' }}"><a href="{{url('/admin/permission/list')}}">Permission List</a></li>
                    </ul>
                </li>

                <li class="{{ request()->is('admin/config/*') ? 'active' : '' }}">
                    <a href="#"><i class="fa fa-list"></i> Configuration
                        <span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level collapse">
                        <li class="{{ request()->is('admin/config/*') ? 'active' : '' }}"><a href="{{url('/admin/config/code-group/list')}}">Code Group List</a></li>
                        <li class="{{ request()->is('admin/config/*') ? 'active' : '' }}"><a href="{{url('/admin/config/code-item/list')}}">Code Item List</a></li>
                        <li class="{{ request()->is('admin/config/*') ? 'active' : '' }}"><a href="{{url('/admin/config/language/list')}}">Language List</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        
<!--         In the side menu, create a new tab called Reports -->
        <li class="{{request()->is(['admin/reports/*']) ? 'active' : ''}}">
            <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">Reports </span>
                <span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                <li class="{{ request()->is('admin/reports/*') ? 'active' : '' }}">
<!--                 Underneath Reports create User Status -->
                    <a href="#"><i class="fa fa-user"></i>User Status
                        <span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level collapse">
<!--                     Create a link to User Status Pie Chart -->
                        <li class=" {{ request()->is('/admin/reports/*') ? 'active' : '' }}"><a href="{{url('/admin/reports/pie-chart')}}">User Status Pie Chart</a></li>
                    		<li class="{{ request()->is('admin/reports/*') ? 'active' : '' }}"><a href="{{url('/admin/reports/items')}}">Import/Export</a></li>
                    </ul>
                </li>
	        </ul>
		</li>
    @endif
</ul>
