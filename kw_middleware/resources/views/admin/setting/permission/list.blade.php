@extends('layouts.admin')

@section('header')
    <!-- Datatables -->
    <link href="{{asset('resources/admin/plugin/datatables.net-bs/css/dataTables.bootstrap.min.css')}}" rel="stylesheet">
    <link href="{{asset('resources/admin/plugin/datatables.net-buttons-bs/css/buttons.bootstrap.min.css')}}" rel="stylesheet">
    <link href="{{asset('resources/admin/plugin/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css')}}" rel="stylesheet">
    <link href="{{asset('resources/admin/plugin/datatables.net-responsive-bs/css/responsive.bootstrap.min.css')}}" rel="stylesheet">
    <link href="{{asset('resources/admin/plugin/datatables.net-scroller-bs/css/scroller.bootstrap.min.css')}}" rel="stylesheet">
@endsection
@section('content')
    <input type="hidden" id="hd_define" data-link="{{ url('/admin/permission/edit') }}" data-active-link="{{ url('/admin/permission/active') }}" >
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Permission List</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>Role Management</a>
                </li>
                <li class="active">
                    <strong>Permission List</strong>
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
                            <a href="{{ url('/admin/permission/register') }}" class="btn btn-success">Create</a>
                        </div>
                        <table id="datatable-responsive" class="display table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th class="text-center">Create Date</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            @foreach ($permissions as $indexKey => $permission)
                                <tr>
                                    <td>
                                        {{ $indexKey + 1 }}
                                    </td>
                                    <td>
                                        {{ $permission->name }}
                                    </td>
                                    <td class="text-center">
                                        {{ $permission->created_at->format('m/d/y H:i:s') }}
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn btn-primary" onclick="javascript:actionEdit('{{ $permission->id }}');"><span class="fa fa-edit"></span></button>
                                        <button type="button" class="btn btn-danger" onclick="javascript:confirmAct('D', '{{ $permission->id }}', '{{ $permission->name }}', '{{ $indexKey + 1 }}');"><span class="fa fa-trash"></span></button>
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
        <input type="hidden" id="act-modal-permission-id">
        <input type="hidden" id="act-modal-permission-name">
        <input type="hidden" id="act-modal-table-index">
    </div>
@endsection

@section('after-script')

    <script src="{{asset('resources/admin/plugin/datatables.net/js/jquery.dataTables.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net/js/fnFindCellRowIndexes.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-bs/js/dataTables.bootstrap.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-buttons/js/dataTables.buttons.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-buttons-bs/js/buttons.bootstrap.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-buttons/js/buttons.flash.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-buttons/js/buttons.html5.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-buttons/js/buttons.print.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-keytable/js/dataTables.keyTable.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-responsive/js/dataTables.responsive.min.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-responsive-bs/js/responsive.bootstrap.js')}}"></script>
    <script src="{{asset('resources/admin/plugin/datatables.net-scroller/js/dataTables.scroller.min.js')}}"></script>

    <script>
        $(document).ready(function() {
            $('#datatable-responsive').DataTable({
                pageLength: 50,
                responsive: true,
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    {extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel', title: 'ExampleFile'},
                    {extend: 'pdf', title: 'ExampleFile'},

                    {extend: 'print',
                        customize: function (win){
                            $(win.document.body).addClass('white-bg');
                            $(win.document.body).css('font-size', '10px');
                            $(win.document.body).find('table')
                                .addClass('compact')
                                .css('font-size', 'inherit');
                        }
                    }
                ]
            });
        });

        function actionEdit(role_id) {
            var redirect = $('#hd_define').attr('data-link');
            location.href = redirect + '/' + role_id;
        }

        function confirmAct(type, permission_id, permission_name, table_index) {
            $('#act-modal-type').val(type);
            $('#act-modal-permission-id').val(permission_id);
            $('#act-modal-permission-name').val(permission_name);
            $('#act-modal-table-index').val(table_index);

            swal({
                title: 'Delete Permission',
                text: 'Are you sure? [' + permission_name + ']',
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "No",
                cancelButtonColor: "#DD6B55",
                confirmButtonColor: "#2a72dd",
                confirmButtonText: "Yes",
            }, function(isConfirm) {
                if(isConfirm) {
                    actionActive();
                }
            });
        }

        function actionActive() {
            var url = $('#hd_define').data('active-link');
            var action_flag = $('#act-modal-type').val() == 'A' ? 'N' : 'Y';

            var param = {
                _token: $('meta[name="csrf-token"]').attr('content'),
                'permission_id' : $('#act-modal-permission-id').val()
                ,'action_flag' : action_flag
            }

            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(param),
                contentType: 'application/json; charset=utf-8',
                dataType: "json",
                success: function(data) {
                    if(data.status_code == 200) {
                        var role_id = $('#act-modal-permission-id').val();
                        var role_name = $('#act-modal-permission-name').val();
                        var table_index = $('#act-modal-table-index').val();

                        var table = $('#datatable-responsive').DataTable();
                        var rowId = $('#datatable-responsive').dataTable()
                            .fnFindCellRowIndexes(table_index, 0);

//                        var active_text = 'Active';
//                        var action_html = '<button type="button" class="btn btn-primary" onclick="javascript:actionEdit(\''+ user_id + '\');"><span class="fa fa-edit"></span></button>';
//
//                        if(action_flag == 'Y') {
//                            active_text = 'Inactive';
//                            action_html += '<button type="button" class="btn btn-success" onclick="javascript:confirmAct(\'A\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
//                                '<span class="fa fa-check-circle"></span></button>';
//                        } else {
//                            action_html += '<button type="button" class="btn btn-danger" onclick="javascript:confirmAct(\'D\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
//                                '<span class="fa fa-trash"></span></button>';
//                        }

                        table.row(rowId)
                            .remove()
                            .draw();

                        table.rows().every(function (rowIdx, tableLoop, rowLoop) {
                            var data = this.data();

                            table.cell(rowIdx, 0)
                                .data((rowIdx + 1))
                                .draw(false);
                        });

                        $('#act-modal-type').val('');
                        $('#act-modal-permission-id').val('');
                        $('#act-modal-permission-name').val('');
                        $('#act-modal-table-index').val('');
                        $('#act-modal-title').text('');
                        $('#act-modal-title-small').text('');
                    }
                },
                failure: function(errMsg) {
                    alert(errMsg);
                }
            });
        }

    </script>

@endsection