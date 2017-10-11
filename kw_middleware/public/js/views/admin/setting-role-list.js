/* Copyright (C) KWI <http://www.kwinternational.com> */

/**
 * admin.setting-role-list.js ready to page
 *
 * @author Jeff So
 * @brief Admin Setting의 Role View 관련 Script
 */
$(function() {

    $('#datatable-responsive').DataTable({
        pageLength: 50,
        responsive: true,
        dom: '<"html5buttons"B>lTfgitp',
        columnDefs: [
            { "orderable":false, "targets": 4 }
        ],
        buttons: [
            { extend: 'copy'},
            { extend: 'csv'},
            { extend: 'excel', title: 'role_list'},
            { extend: 'pdf', title: 'role_list'},
            { extend: 'print',
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

/**
 * Move User edit page
 *
 * @param var id UserId
 */
function action_edit(id) {
    var redirect = $('#hd_define').attr('data-link');
    location.href = redirect + '/' + id;
}

/**
 * Confirm Role Delete or Activation
 *
 * @param var type
 * @param var role_id
 * @param var role_name
 * @param var table_index
 */
function confirm_active(type, role_id, role_name, table_index) {
    $('#act-modal-type').val(type);
    $('#act-modal-role-id').val(role_id);
    $('#act-modal-role-name').val(role_name);
    $('#act-modal-table-index').val(table_index);

    var title = 'Delete Role';
    var message = 'Are you sure? [' + role_name + ']';

    show_message_with_confirm(title,
        message,
        'warning', 'Yes', 'No'
    ).then(function () {
        action_active();
    }, function (dismiss) {
        // dismiss can be 'cancel', 'overlay',
        // 'close', and 'timer'
        if (dismiss === 'cancel') {

        }
    })
}

/**
 * Send ROle Delete or Activation information.
 */
function action_active() {
    var url = $('#hd_define').data('active-link');
    var del_flag = $('#act-modal-type').val() == 'A' ? 'N' : 'Y';

    var param = {
        'role_id' : $('#act-modal-role-id').val()
        ,'del_flag' : del_flag
    }

    $.ajax({
        type: 'POST',
        url: url,
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'X-CSRF-TOKEN' : $('meta[name="csrf-token"]').attr('content')
        },
        data: JSON.stringify(param),
        contentType: 'application/json; charset=utf-8',
        dataType: "json",
        success: function(data) {
            if(data.status_code == 200) {
                var role_id = $('#act-modal-role-id').val();
                var role_name = $('#act-modal-role-name').val();
                var table_index = $('#act-modal-table-index').val();

                var table = $('#datatable-responsive').DataTable();
                var row_id = $('#datatable-responsive').dataTable()
                    .fnFindCellRowIndexes(table_index, 0);

                table.row(row_id)
                    .remove()
                    .draw();

                table.rows().every(function (row_idx, tableLoop, rowLoop) {
                    var data = this.data();

                    table.cell(row_idx, 0)
                        .data((row_idx + 1))
                        .draw(false);
                });

                $('#act-modal-type').val('');
                $('#act-modal-role-id').val('');
                $('#act-modal-role-name').val('');
                $('#act-modal-table-index').val('');
            }
        },
        failure: function(error_message) {
            show_message('Fail', error_message, 'error', 'OK');
        }
    });
}