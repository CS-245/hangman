/* Copyright (C) KWI <http://www.kwinternational.com> */

/**
 * app-common.js ready to page
 *
 * @author Jeff So
 */
$(function() {

});


/**
 * Show Message Box
 *
 * @author Jeff So
 * @param var txt_title
 * @param var txt_message
 * @param var type
 * @param var btn_text
 * @return sweetalert Object
 */
function show_message(txt_title, txt_message, type, btn_text) {
    return swal({
        title: txt_title,
        text: txt_message,
        type: type,
        confirmButtonText: btn_text
    });
}

function show_message_with_confirm(txt_title, txt_message, type, btn_text, btn_cancel_text) {
    return swal({
        title: txt_title,
        text: txt_message,
        type: type,
        showCancelButton: true,
        cancelButtonText: btn_cancel_text,
        confirmButtonText: btn_text
    });
}