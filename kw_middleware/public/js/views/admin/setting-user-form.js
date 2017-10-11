/* Copyright (C) KWI <http://www.kwinternational.com> */

/**
 * admin.setting-user-form.js ready to page
 *
 * @author Jeff So
 * @brief Admin Setting의 User Form 관련 Script
 */
$(function() {
    $('#select-permission').multiselect({
        enableFiltering: true,
        includeSelectAllOption: true,
        maxHeight: 120
    });

    $('#check-activate-yn').on('change', function () {
        var check_value = $('#check-activate-yn').is(':checked') ? 'Y' : 'N';
        $('input[name="activate_yn"]').val(check_value);
    });
});
