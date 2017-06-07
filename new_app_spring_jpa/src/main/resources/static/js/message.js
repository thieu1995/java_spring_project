/**
 * Created by thieunv on 08/06/2017.
 */

function autoRemoveMessages() {
    window.setTimeout(function () {
        $('.alert_spring_normal').remove();
    },3000)
}

function autoHideMessages() {
    window.setTimeout(function () {
        $('.alert_restful').hide();
    },3000)
}
