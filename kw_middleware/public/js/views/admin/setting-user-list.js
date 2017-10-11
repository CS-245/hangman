/* Copyright (C) KWI <http://www.kwinternational.com> */


/**
 * admin.setting-user-list.js ready to page
 *
 * @author Jeff So
 * @brief Admin Setting의 User View 관련 Script
 */
$(document).ready(function() {

    var table = $('#datatable-responsive').DataTable({
        pageLength: 50,
        responsive: true,
        dom: 'Z<"html5buttons"B>lTfgitp',
        columnDefs: [
            { "orderable":false, "targets": 7 }
        ],
        colReorder: true,
        buttons: [    
            { extend: 'copy'},
            { extend: 'csv'},
            { extend: 'colvis',
            		columnText: function ( dt, idx, title ) {
                    return (idx+1)+': '+title;
                }            	
            },
            { extend: 'excel'},
            { extend: 'pdf' },
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
      
    $('#column-visible').multiselect({
        enableFiltering: true,
        includeSelectAllOption: true,
        selectAllJustVisible: true,
        //Individual Change
        onChange: function(option, checked, select) {
        		if(!checked){            		
        			        			
        			table.column( $(option).val() ).visible( true );
        			
        		}
        		else{
        			
        			table.column( $(option).val() ).visible( false );
        		
        		}
        },
        //Select All 
        onSelectAll: function() {
        		table.columns().visible( false );        
        	},
        	//Deselect All
        	onDeselectAll: function() {
        		table.columns().visible( true );        
        }
    });
    table.columns.adjust().draw( false ); // adjust column sizing and redraw

});

/**
 * Move User edit page
 *
 * @param var id UserId
 */
function action_edit(id) {
    var redirect = $('#hd_define').data('link');
    location.href = redirect + '/' + id;
}

/**
 * Confirm User Delete or Activation
 *
 * @param var type
 * @param var user_id
 * @param var user_name
 * @param var user_email
 * @param var table_index
 */
function confirm_active(type, user_id, user_name, user_email, table_index) {
    $('#act-modal-type').val(type);
    $('#act-modal-user-id').val(user_id);
    $('#act-modal-user-name').val(user_name);
    $('#act-modal-user-email').val(user_email);
    $('#act-modal-table-index').val(table_index);

    var title = '';
    var message = '';
    var action_type = 'Delete';
    var action_flag = 'Y';

    if(type == 'A') {
        title = 'UnDelete User';
        message = '' + user_email;
        action_flag = 'N';
    }
    else if(type == 'D') {
        title = 'Delete User';
        message = '' + user_email;
    }
    else if(type == 'AA') {
        title = 'Activation User';
        message = '' + user_email;
        action_type = 'Activation';
    }
    else if(type == 'AD') {
        title = 'InActivation User';
        message = '' + user_email;
        action_type = 'Activation';
        action_flag = 'N';
    }

    show_message_with_confirm(title,
        message,
        'warning', 'Yes', 'No'
    ).then(function () {
        action_active(action_type, action_flag);
    }, function (dismiss) {
        // dismiss can be 'cancel', 'overlay',
        // 'close', and 'timer'
        if (dismiss === 'cancel') {

        }
    })
}

/**
 * Send User Delete or Activation information.
 *
 * @param var action_type
 * @param var action_flag
 */
function action_active(action_type, action_flag) {
    var url = $('#hd_define').data('active-link');
    var param = {
        'user_id' : $('#act-modal-user-id').val()
        ,'action_type' : action_type
        ,'action_flag' : action_flag
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
                var user_id = $('#act-modal-user-id').val();
                var user_name = $('#act-modal-user-name').val();
                var user_email = $('#act-modal-user-email').val();
                var table_index = $('#act-modal-table-index').val();

                var table = $('#datatable-responsive').DataTable();
                var row_id = $('#datatable-responsive').dataTable()
                    .fnFindCellRowIndexes(table_index, 0);

                var action_html = '<button type="button" class="btn btn-primary" onclick="javascript:action_edit(\''+ user_id + '\');"><span class="fa fa-edit"></span></button>';
                var activation_text = 'Yes';
                var delete_text = 'Yes';

                if(action_type == 'Delete') {
                    activation_text = table.cell(row_id, 4).data();

                    if(activation_text == 'Yes') {
                        action_html += ' <button type="button" class="btn btn-danger" onclick="javascript:confirm_active(\'AD\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-trash"></span></button>';
                    } else {
                        action_html += ' <button type="button" class="btn btn-success" onclick="javascript:confirm_active(\'AA\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-check-circle"></span></button>';
                    }

                    if(action_flag == 'Y') {
                        action_html += ' <button type="button" class="btn btn-success" onclick="javascript:confirm_active(\'A\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-check-circle"></span></button>';
                    } else {
                        delete_text = 'No';
                        action_html += ' <button type="button" class="btn btn-danger" onclick="javascript:confirm_active(\'D\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-trash"></span></button>';
                    }
                } else {
                    delete_text = table.cell(row_id, 5).data();

                    if(action_flag == 'Y') {
                        action_html += ' <button type="button" class="btn btn-danger" onclick="javascript:confirm_active(\'AD\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-trash"></span></button>';
                    } else {
                        activation_text = 'No';
                        action_html += ' <button type="button" class="btn btn-success" onclick="javascript:confirm_active(\'AA\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-check-circle"></span></button>';
                    }

                    if(delete_text == 'Yes') {
                        action_html += ' <button type="button" class="btn btn-success" onclick="javascript:confirm_active(\'A\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-check-circle"></span></button>';
                    } else {
                        action_html += ' <button type="button" class="btn btn-danger" onclick="javascript:confirm_active(\'D\', \'' + user_id + '\', \'' + user_name + '\', \'' + user_email + '\', \'' + table_index + '\');">' +
                            '<span class="fa fa-trash"></span></button>';
                    }
                }

                table.cell(row_id, 4)
                    .data(activation_text)
                    .draw(false);

                table.cell(row_id, 5)
                    .data(delete_text)
                    .draw(false);

                table.cell(row_id, 7)
                    .data(action_html)
                    .draw(false);

                $('#act-modal-type').val('');
                $('#act-modal-user-id').val('');
                $('#act-modal-user-name').val('');
                $('#act-modal-user-email').val('');
                $('#act-modal-table-index').val('');
            }
        },
        failure: function(error_message) {
            show_message('Fail', error_message, 'error', 'OK');
        }
    });
}

/**
 * Upload File
 */
function upload() {
    var url = $('#hd_define').data('upload-link');
    
    var formData = new FormData;
	formData.append('uploadFile', $('#uploadFile')[0].files[0]);
	
    $.ajax({
        type: 'POST',
        url: url,
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'X-CSRF-TOKEN' : $('meta[name="csrf-token"]').attr('content')
        },
        data: formData,
        dataType: "text",
		cache: false,
		contentType: false,
		processData: false,
        success: function(data) {
        	console.log(data);
        	
        },
        failure: function(error_message) {
            show_message('Fail', error_message, 'error', 'OK');
        }
    });
}

