$(document).ready(function() {
    $('.zimNumber').blur(function() {
        $('span.error_phone').html("");
        var inputVal = $(this).val();
        if (inputVal.length != 0) {
            var characterReg = /^(\+?263|0)\s?\d{3}\s?\d{3}\s?\d{3}$/;
            if (!characterReg.test(inputVal)) {
                $(this).before('<span class="error_phone"><b style="color: #c9302c">Please enter valid phone number</b></span>');
                return false;
            }
        }
    })


    $('#idNumber').blur(function() {
        $('span.error_idnumber').html("");
        var inputVal = $(this).val();
        var identityType = $("#identityType").val();
        var characterReg="";
        if(identityType=="NATIONAL_ID"){
            characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
        }
        if(identityType=="DRIVERS_LICENSE"){
            characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
        }
        if(identityType=="PASSPORT"){
            characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
        }
        if (inputVal.length != 0) {
            if (!characterReg.test(inputVal)) {
                $(this).before('<span class="error_idnumber"><b style="color: #c9302c">Please enter valid id number</b></span>');
                return false;
            }
        }
    })


    $('.zimNumber').keyup(function() {
        var inputVal = $(this).val();
        if (inputVal.length === 0) {
            $('span.error_phone').html("");
        }
    })

    $('.nationalId').keyup(function() {
        var inputVal = $(this).val();
        if (inputVal.length === 0) {
            $('#error_spouse_id_number').html('<b id="required">*</b>Id Number: <b style="color: #c9302c"> Please enter valid id number</b>');
            $('span.error_idnumber').html("");
        }
    })

    $('#spouseIdNumber').keyup(function() {
        var inputVal = $(this).val();
        var characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
        if (inputVal.length === 0 || characterReg.test(inputVal)) {
            $('#error_spouse_id_number').html('<b id="required">*</b>Id Number:');
        }
    })

    $('#nextOfKinIdNumber').keyup(function() {
        var inputVal = $(this).val();
        var characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
        if (inputVal.length === 0 || characterReg.test(inputVal)) {
            $('#error_nextofkin_idnumber').html('<b id="required">*</b>Id Number:');
        }

    })
    $('.idNumber').keyup(function() {
        var inputVal = $(this).val();
        if (inputVal.length === 0) {
            $('span.error_idnumber').html("");
        }
    })
});
