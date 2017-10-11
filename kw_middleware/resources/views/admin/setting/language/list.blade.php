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
    <input type="hidden" id="hd_define" data-link="{{ url('/admin/config/language/edit') }}" data-sort-link="{{ url('admin/config/language/list-sort') }}" data-active-link="{{ url('/admin/config/language/active') }}" >
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Language List</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>Code Management</a>
                </li>
                <li class="active">
                    <strong>Language List</strong>
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
                            <a href="{{ url('/admin/config/language/register') }}" class="btn btn-success">Create</a>
                        </div>
                        <table id="datatable-responsive" class="display table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Language Name</th>
                                <th class="text-center">Del Y/N</th>
                                <th class="text-center">Create Date</th>
                                <th class="text-center">Sort Order</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            @foreach ($languages as $indexKey => $language)
                                <tr>
                                    <td>
                                        {{ $indexKey + 1 }}
                                    </td>
                                    <td>
                                        {{ $language->language_name }}
                                    </td>
                                    <td class="text-center">
                                        {{ $language->del_yn == 'Y' ? 'Yes' : 'No' }}
                                    </td>
                                    <td class="text-center">
                                        {{ $language->created_at->format('m/d/y H:i:s') }}
                                    </td>
                                    <td class="text-center">
                                        @php
                                            if(($indexKey + 1) < $languages->count()) {
                                                $n_index = ($indexKey + 1);
                                            } else {
                                                $n_index = ($languages->count() - 1);
                                            }

                                            if(($indexKey - 1) >= 0) {
                                                $p_index = ($indexKey - 1);
                                            } else {
                                                $p_index = 0;
                                            }

                                            $p_language_id = empty($languages->get(($p_index))->language_id) ? '' : $languages->get(($p_index))->language_id;
                                            $n_language_id = empty($languages->get(($n_index))->language_id) ? '' : $languages->get(($n_index))->language_id;
                                        @endphp
                                        <button type="button" class="btn btn-success" onclick="javascript:actionSort('U', 'f_{{ $language->language_id }}', 'u_{{ $p_language_id }}' ,'{{ $language->sort_order }}', '{{ ($language->sort_order - 1) }}', '{{ $indexKey + 1 }}', '{{ ($indexKey + 1) - 1 }}');"><span class="fa fa-arrow-circle-up"></span></button>
                                        <button type="button" class="btn btn-danger" onclick="javascript:actionSort('D', 'f_{{ $language->language_id }}', 'd_{{ $n_language_id }}', '{{ $language->sort_order }}', '{{ ($language->sort_order + 1) }}' , '{{ $indexKey + 1 }}', '{{ ($indexKey + 1) + 1 }}');"><span class="fa fa-arrow-circle-down"></span></button>
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn btn-primary" onclick="javascript:actionEdit('{{ $language->language_id }}');"><span class="fa fa-edit"></span></button>
                                        <button type="button" class="btn btn-danger" onclick="javascript:confirmAct('D', '{{ $language->language_id }}', '{{ $language->language_name }}', '{{ $indexKey + 1 }}');"><span class="fa fa-trash"></span></button>
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
        <input type="hidden" id="act-modal-language-id">
        <input type="hidden" id="act-modal-language-name">
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
        var is_sort = false;
        $(document).ready(function() {
            $('#datatable-responsive').DataTable({
                pageLength: 50,
                responsive: true,
                columnDefs: [
                    { "width": "5%", "targets": 0 },
                    { "width": "5%", "targets": 2 },
                    { "width": "15%", "targets": 3 },
                    { "width": "15%", "targets": 4 },
                    { "width": "15%", "targets": 5 }
                ],
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    { extend: 'copy'},
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

        function actionEdit(id) {
            var redirect = $('#hd_define').attr('data-link');
            location.href = redirect + '/' + id;
        }

        function actionSort(action_type, source_id, target_id, source_sort, target_sort, source_table_index, target_table_index) {
            if(is_sort) {
                return;
            } else {
                var total_cnt = $('#datatable-responsive').DataTable().rows().count();
                source_id = source_id.replace('f_', '');
                target_id = target_id.replace('u_', '');
                target_id = target_id.replace('d_', '');
                if (action_type == 'U' && source_sort == 1) {
                    alert('더 이상 못 올라감');
                }
                else if (action_type == 'D' && target_sort > total_cnt) {
                    alert('더 이상 못 내려감');
                } else {
                    is_sort = true;
                    var url = $('#hd_define').data('sort-link');
                    var param = {
                        _token: $('meta[name="csrf-token"]').attr('content'),
                        'source_id': source_id,
                        'target_id': target_id,
                        'source_sort': source_sort,
                        'target_sort': target_sort
                    };

//                    alert(source_id + '/' + target_id);
//                    alert(source_sort + '/' + target_sort);

                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: JSON.stringify(param),
                        contentType: 'application/json; charset=utf-8',
                        dataType: "json",
                        success: function (data) {
                            if (data.status_code == 200) {
                                var table = $('#datatable-responsive').DataTable();
                                var source_rowId = $('#datatable-responsive').dataTable()
                                    .fnFindCellRowIndexes(source_table_index, 0);
                                var target_rowId = $('#datatable-responsive').dataTable()
                                    .fnFindCellRowIndexes(target_table_index, 0);

//                                alert(target_rowId);
//                                alert(total_cnt);
//                                alert((parseInt(target_rowId) + 1));
//                                alert((target_rowId + 1) <= total_cnt);
//                                alert(source_id + '/' + target_id);

                                var temp_sort_html = table.cell(source_rowId, 4).data().replace(new RegExp('f_[0-9]{1,9}', 'g'), 'f_' + target_id);


//                                alert(temp_sort_html);

                                // sort up..
                                if (action_type == 'U') {
                                    if((parseInt(target_rowId) - 1) > 0) {
                                        table.cell((parseInt(target_rowId) - 1), 4).data(table.cell((parseInt(target_rowId) - 1), 4).data().replace(new RegExp('d_[0-9]{1,9}', 'g'), 'd_' + source_id));
//                                        alert(table.cell((parseInt(target_rowId) - 1), 4).data());
                                    }

                                    if((parseInt(source_rowId) + 1) < total_cnt) {
                                        table.cell((parseInt(source_rowId) + 1) , 4).data(table.cell((parseInt(source_rowId) + 1) , 4).data().replace(new RegExp('u_[0-9]{1,9}', 'g'), 'u_' + target_id));
//                                        alert(table.cell((parseInt(target_rowId) - 1), 4).data());
                                    }

                                    table.cell(source_rowId, 4).data(table.cell(target_rowId, 4).data().replace(new RegExp('f_[0-9]{1,9}', 'g'), 'f_' + source_id)
                                                                                .replace(new RegExp('d_[0-9]{1,9}', 'g'), 'd_' + target_id));

                                    temp_sort_html = temp_sort_html.replace(new RegExp('u_[0-9]{1,9}', 'g'), 'u_' + source_id);
                                } else { // sort down
                                    if((parseInt(source_rowId) - 1) > 0) {
                                        table.cell((parseInt(source_rowId) - 1), 4).data(table.cell((parseInt(source_rowId) - 1), 4).data().replace(new RegExp('d_[0-9]{1,9}', 'g'), 'd_' + target_id));
//                                        alert(table.cell((parseInt(source_rowId) - 1), 4).data());
                                    }

                                    if((parseInt(target_rowId) + 1) < total_cnt) {
                                        table.cell((parseInt(target_rowId) + 1), 4).data(table.cell((parseInt(target_rowId) + 1), 4).data().replace(new RegExp('u_[0-9]{1,9}', 'g'), 'u_' + source_id));
//                                        alert(table.cell((parseInt(target_rowId) + 1), 4).data());
                                    }
                                    table.cell(source_rowId, 4).data(table.cell(target_rowId, 4).data().replace(new RegExp('f_[0-9]{1,9}', 'g'), 'f_' + source_id)
                                                                                .replace(new RegExp('u_[0-9]{1,9}', 'g'), 'u_' + target_id));

                                    temp_sort_html = temp_sort_html.replace(new RegExp('d_[0-9]{1,9}', 'g'), 'd_' + source_id);
                                }

//                                alert(source_id + '/' + target_id);
//                                alert(temp_sort_html);

                                table.cell(target_rowId, 4).data(temp_sort_html);
                                var temp_data = table.row(source_rowId).data();
                                table.row(source_rowId).data(table.row(target_rowId).data());
                                table.row(target_rowId).data(temp_data);

                                table.rows().every(function (rowIdx, tableLoop, rowLoop) {
                                    table.cell(rowIdx, 0)
                                        .data((rowIdx + 1))
                                        .draw(false);
                                });

                                setTimeout(function() {
                                    sort_success();
                                }, 800);
                            }
                        },
                        failure: function (errMsg) {
                            alert(errMsg);
                        }
                    });
                }
            }
        }

        function sort_success() {
            is_sort = false;
        }

        function confirmAct(type, language_id, language_name, table_index) {
            $('#act-modal-type').val(type);
            $('#act-modal-language-id').val(language_id);
            $('#act-modal-language-name').val(language_name);
            $('#act-modal-table-index').val(table_index);

            swal({
                title: 'Delete LanguageModel',
                text: 'Are you sure? [' + language_name + ']',
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
                'language_id' : $('#act-modal-language-id').val()
                ,'action_flag' : action_flag
            };

            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(param),
                contentType: 'application/json; charset=utf-8',
                dataType: "json",
                success: function(data) {
                    if(data.status_code == 200) {
                        var role_id = $('#act-modal-language-id').val();
                        var role_name = $('#act-modal-language-name').val();
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
                        $('#act-modal-language-id').val('');
                        $('#act-modal-language-name').val('');
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