@extends('layouts.admin.app')

@section('header')
    <!-- Datatables -->
    <link href="{{ asset('vendor/datatables.net-bs/css/dataTables.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-buttons-bs/css/buttons.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-responsive-bs/css/responsive.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-scroller-bs/css/scroller.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/bootstrap-multiselect/css/bootstrap-multiselect.css') }}" rel="stylesheet">
@endsection
@section('content')
    <input type="hidden" id="hd_define" data-link="{{ url('/admin/user/edit') }}" data-active-link="{{ url('/api/v1/user/active') }}" data-upload-link="{{ url('/admin/user/upload') }}">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>User List</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>User Management</a>
                </li>
                <li class="active">
                    <strong>User List</strong>
                </li>
            </ol>
        </div>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5></h5>
                    </div>
<!--                     create a select drop down box with the options of the datatables' column names -->
                    <div class="ibox-content">
                        <select id="column-visible" multiple="multiple">
                            
                  			
                            <option id="no" value="0">Number</option>
                            <option id="name" value="1">Name</option>
                            <option id="email" value="2">Email</option>
                            <option id="auth" value="3">Authentication</option>
                            <option id="active" value="4">Activation</option>
                            <option id="del" value="5">Delete</option>
                            <option id="create" value="6">Create</option>
                            <option id="action" value="7">Action</option>   
						
						</select>
                        
                   
                        <div class="text-right" style="padding-bottom: 6px">
                            <a href="{{url('/admin/user/register')}}" class="btn btn-success">Create</a>
                        </div>
                        <table id="datatable-responsive" class="display table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th width="1%">No</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th class="text-center">Auth</th>
                                <th class="text-center">Activation</th>
                                <th class="text-center">Del Y/N</th>
                                <th class="text-center">Create Date</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            @foreach ($users as $indexKey => $user)
                                <tr>
                                    <td class="text-center">
                                        {{$indexKey + 1}}
                                    </td>
                                    <td>
                                        <a href="javascript:action_edit('{{ $user->user_id }}');">{{ $user->getFullName() }}</a>
                                    </td>
                                    <td>
                                        <a href="javascript:action_edit('{{ $user->user_id }}');">{{ $user->email }}</a>
                                    </td>
                                    <td>
                                        @foreach($user->roles as $roleIndex => $role)
                                            @if($roleIndex == 0)
                                                {{ $role->name }}
                                            @else
                                                , {{ $role->name }}
                                            @endif
                                        @endforeach
                                    </td>
                                    <td class="text-center">
                                        @if($user->activate_yn == 'N')
                                            No
                                        @else
                                            Yes
                                        @endif
                                    </td>
                                    <td class="text-center">
                                        @if($user->del_yn == 'N')
                                            No
                                        @else
                                            Yes
                                        @endif
                                    </td>
                                    <td class="text-center">
                                        {{$user->created_at->format('m/d/y H:i:s')}}
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn btn-primary" onclick="javascript:action_edit('{{ $user->user_id }}');"><span class="fa fa-edit"></span></button>
                                        @if($user->activate_yn == 'Y')
                                            <button type="button" class="btn btn-danger" onclick="javascript:confirm_active('AD', '{{ $user->user_id }}', '{{ $user->name }}', '{{ $user->email }}', '{{$indexKey + 1}}');"><span class="fa fa-trash"></span></button>
                                        @else
                                            <button type="button" class="btn btn-success" onclick="javascript:confirm_active('AA', '{{ $user->user_id }}', '{{ $user->name }}', '{{ $user->email }}', '{{$indexKey + 1}}');"><span class="fa fa-check-circle"></span></button>
                                        @endif

                                        @if($user->del_yn == 'N')
                                            <button type="button" class="btn btn-danger" onclick="javascript:confirm_active('D', '{{ $user->user_id }}', '{{ $user->name }}', '{{ $user->email }}', '{{$indexKey + 1}}');"><span class="fa fa-trash"></span></button>
                                        @else
                                            <button type="button" class="btn btn-success" onclick="javascript:confirm_active('A', '{{ $user->user_id }}', '{{ $user->name }}', '{{ $user->email }}', '{{$indexKey + 1}}');"><span class="fa fa-check-circle"></span></button>
                                        @endif
                                    </td>
                                </tr>
                            @endforeach
                            </tbody>
                        </table>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display: none;">
        <input type="hidden" id="act-modal-type">
        <input type="hidden" id="act-modal-user-id">
        <input type="hidden" id="act-modal-user-name">
        <input type="hidden" id="act-modal-user-email">
        <input type="hidden" id="act-modal-table-index">
    </div>
    
@endsection

@section('after-script')

    <script src="{{ asset('vendor/datatables.net/js/jquery.dataTables.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net/js/fnFindCellRowIndexes.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-bs/js/dataTables.bootstrap.min.js') }}"></script>
         
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.buttons.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.flash.min.js') }}"></script>
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/jszip.min.js') }}"></script>   
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colReorder.min.js') }}"></script>   
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colResize.js') }}"></script>   
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.html5.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.print.min.js') }}"></script>
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.colvis.min.js') }}"></script>
    <script src="{{ asset('vendor/bootstrap-multiselect/js/bootstrap-multiselect.js') }}"></script>

    <script src="{{ asset('vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-keytable/js/dataTables.keyTable.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive/js/dataTables.responsive.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-scroller/js/dataTables.scroller.min.js') }}"></script>
    <script src="{{ asset('js/views/admin/setting-user-list.js') }}"></script>
    
@endsection