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
        maxHeight: 240
    });
});
