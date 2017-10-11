@extends('layouts.admin.app')

@section('header')
    <!-- Datatables -->
    <link href="{{ asset('vendor/datatables.net-bs/css/dataTables.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-buttons-bs/css/buttons.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-responsive-bs/css/responsive.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-scroller-bs/css/scroller.bootstrap.min.css') }}" rel="stylesheet">
@endsection
@section('content')
    <input type="hidden" id="hd_define" data-link="{{ url('/admin/role/edit') }}" data-active-link="{{ url('/api/v1/role/active') }}" >
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Role List</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>Role Management</a>
                </li>
                <li class="active">
                    <strong>Role List</strong>
                </li>
            </ol>
        </div>
    </div>

    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5></h5>
                    </div>
                    <div class="ibox-content">
                        <p>
                        </p>
                        <div class="text-right" style="padding-bottom: 6px">
                            <a href="{{url('/admin/role/register')}}" class="btn btn-success">Create</a>
                        </div>
                        <table id="datatable-responsive" class="display table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th width="1%">No</th>
                                <th >Name</th>
                                <th>Permissions</th>
                                <th class="text-center" width="10%">Create Date</th>
                                <th class="text-center" width="10%">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            @foreach ($roles as $indexKey => $role)
                                <tr>
                                    <td>
                                        {{$indexKey + 1}}
                                    </td>
                                    <td>
                                        @if($role->name != 'Super Admin')
                                            <a href="javascript:action_edit('{{ $role->id }}');">{{ $role->name }}</a>
                                        @else
                                            {{ $role->name }}
                                        @endif
                                    </td>
                                    <td>
                                        @foreach($role->permissions as $perIndex => $permission)
                                            @if($perIndex == 0)
                                                {{ $permission->name }}
                                            @else
                                                , {{ $permission->name }}
                                            @endif
                                        @endforeach
                                    </td>
                                    <td class="text-center">
                                        {{$role->created_at->format('m/d/y H:i:s')}}
                                    </td>
                                    <td class="text-center">
                                        @if($role->name != 'Super Admin')
                                            <button type="button" class="btn btn-primary" onclick="javascript:action_edit('{{ $role->id }}');"><span class="fa fa-edit"></span></button>
                                            <button type="button" class="btn btn-danger" onclick="javascript:confirm_active('D', '{{ $role->id }}', '{{ $role->name }}', '{{$indexKey + 1}}');"><span class="fa fa-trash"></span></button>
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
        <input type="hidden" id="act-modal-role-id">
        <input type="hidden" id="act-modal-role-name">
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
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.html5.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.print.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-keytable/js/dataTables.keyTable.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive/js/dataTables.responsive.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-scroller/js/dataTables.scroller.min.js') }}"></script>
    <script src="{{ asset('js/views/admin/setting-role-list.js') }}"></script>
@endsection