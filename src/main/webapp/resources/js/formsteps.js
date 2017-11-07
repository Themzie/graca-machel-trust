$(document).ready(function() {

	var form = $("#registration").show();

	form.steps({
		headerTag: "h6",
		bodyTag: "fieldset",
		transitionEffect: "slideLeft",
		onStepChanging: function (event, currentIndex, newIndex)
		{
			//$('span.error_payment_method').html("");
			// Used to skip validation when the concerned tabs are not displayed
			if ((currentIndex === 3 || currentIndex === 4|| currentIndex === 5) && $("#mainCustomerType").val() != "INDIVIDUAL"){
				return true;
			}
			else{
				if(currentIndex===0 && currentIndex < newIndex){

					$("#paymentMethod").html('<label id="paymentMethod"><b id="required">*</b>Preferred Payment Method(s):</b></label><br>');
					var inputVal = $("#idNumber").val();
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
					if (inputVal.length!=0 && !characterReg.test(inputVal) ) {
						return false;
					}
					if($('.paymentMethodCheckBoxes:checked').length===0){
						$("#paymentMethod").html('<label id="paymentMethod"><b id="required">*</b>Preferred Payment Method(s):<b style="color: #c9302c">Please select at least one method</b></b></label><br>');
					}
				}
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
				if(currentIndex===1 && currentIndex < newIndex){
					var inputVal = $("#contactNumber").val();
					var characterReg = /^(\+?263|0)\s?\d{3}\s?\d{3}\s?\d{3}$/;
					if (inputVal.length!=0 && !characterReg.test(inputVal) ) {
						return false;
					}
				}

				if(currentIndex===3 && currentIndex < newIndex){
					var inputVal = $("#employerPhoneNumber").val();
					var characterReg = /^(\+?263|0)\s?\d{3}\s?\d{3}\s?\d{3}$/;
					if (inputVal.length!=0 && !characterReg.test(inputVal)) {
						return false;
					}
				}
				if(currentIndex===4 && currentIndex < newIndex){
					var inputVal = $("#spousePhone").val();
					var characterReg = /^(\+?263|0)\s?\d{3}\s?\d{3}\s?\d{3}$/;
					if (inputVal.length!=0 && !characterReg.test(inputVal)) {
						return false;
					}
					$('#error_spouse_id_number').html('<b id="required">*</b>Id Number:');
					var inputVal = $("#spouseIdNumber").val();
					characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
					if (inputVal.length != 0) {
						if (!characterReg.test(inputVal)) {
							$('#error_spouse_id_number').html('<b id="required">*</b>Id Number: <b style="color: #c9302c"> Please enter valid id number</b>');
							return false;
						}
					}
				}
				if(currentIndex===5 && currentIndex < newIndex){
					var inputVal = $("#nextOfKinPhoneNumber").val();
					var characterReg = /^(\+?263|0)\s?\d{3}\s?\d{3}\s?\d{3}$/;
					if (inputVal.length!=0 && !characterReg.test(inputVal)) {
						return false;
					}
					$('#error_nextofkin_idnumber').html('<b id="required">*</b>Id Number:');
					var inputVal = $("#nextOfKinIdNumber").val();
					characterReg = /^\d{2}\-?\d?\d{6}\-?(([A-H]|[J-N]|[P-T]|[V-Z])|([a-h]|[j-n]|[p-t]|[v-z]))\-?\d{2}$/;
					if (inputVal.length != 0) {
						if (!characterReg.test(inputVal)) {
							$('#error_nextofkin_idnumber').html('<b id="required">*</b>Id Number: <b style="color: #c9302c"> Please enter valid id number</b>');
							return false;
						}
					}
				}
				if(currentIndex===6 && currentIndex < newIndex){
					$("#bankStatementError").html("");
					var bankStatement = $('#bankStatement')[0].files[0];
					var proofOfIncome = $('#proofOfIncome')[0].files[0];
					var proofOfResidence = $('#proofOfResidence')[0].files[0];
					var identityDocument = $('#identityDocument')[0].files[0];
					var maxFileSize = 2097152;
					if(bankStatement ){
						var fileExtension = bankStatement.name.substr(bankStatement.name.lastIndexOf('.') +1);
						if(fileExtension!="pdf" && fileExtension !="jpeg" && fileExtension !="jpg" && fileExtension!="png"){
							$("#bankStatementError").html("Invalid file type");
							$("#bankStatementError").css("color","#c9302c");
							return false;
						}
					}
					if(bankStatement && bankStatement.size > maxFileSize) {
						$("#bankStatementError").html("File size is greater than 2MB");
						$("#bankStatementError").css("color","#c9302c");
						return false;
					}
					if(identityDocument ){
						var fileExtension = identityDocument.name.substr(identityDocument.name.lastIndexOf('.') +1);
						if(fileExtension!="pdf" && fileExtension !="jpeg" && fileExtension !="jpg" && fileExtension!="png"){
							$("#identityDocError").html("Invalid file type");
							$("#identityDocError").css("color","#c9302c");
							return false;
						}
					}
					if(identityDocument && identityDocument.size > maxFileSize) {
						$("#identityDocError").html("File size is greater than 2MB");
						$("#identityDocError").css("color","#c9302c");
						return false;
					}
					if(proofOfIncome ){
						var fileExtension = proofOfIncome.name.substr(proofOfIncome.name.lastIndexOf('.') +1);
						if(fileExtension!="pdf" && fileExtension !="jpeg" && fileExtension !="jpg" && fileExtension!="png"){
							$("#proofOfIncomeError").html("Invalid file type");
							$("#proofOfIncomeError").css("color","#c9302c");
							return false;
						}
					}
					if(proofOfIncome && proofOfIncome.size > maxFileSize) {
						$("#proofOfIncomeError").html("File size is greater than 2MB");
						$("#proofOfIncomeError").css("color","#c9302c");
						return false;
					}
					if(proofOfResidence ){
						var fileExtension = proofOfResidence.name.substr(proofOfResidence.name.lastIndexOf('.') +1);
						if(fileExtension!="pdf" && fileExtension !="jpeg" && fileExtension !="jpg" && fileExtension!="png"){
							$("#proofOfResidenceError").html("Invalid file type");
							$("#proofOfResidenceError").css("color","#c9302c");
							return false;
						}
					}
					if(proofOfResidence && proofOfResidence.size > maxFileSize) {
						$("#proofOfResidenceError").html("File size is greater than 2MB");
						$("#proofOfResidenceError").css("color","#c9302c");
						return false;
					}
					return true;
				}

				// Allways allow previous action even if the current form is not valid!
				if (currentIndex > newIndex)
				{
					return true;
				}
				// Needed in some cases if the user went back (clean up)
				if (currentIndex < newIndex)
				{
					// To remove error styles
					form.find(".body:eq(" + newIndex + ") label.error").remove();
					form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
				}
				form.validate().settings.ignore = ":disabled,:hidden";
				var returnValue= form.valid()
				if($('.paymentMethodCheckBoxes:checked').length===0){
					return false;
				}
				return returnValue;
				//form.valid();
			}



		},
		onStepChanged: function (event, currentIndex, priorIndex)
		{
			if (currentIndex === 1){
					$(".content").css("min-height", "35em");
					$("#formStage").html("Contact Details")
				}
			if (currentIndex === 0 && $("#mainCustomerType").val()==="COMPANY"){
					$(".content").css("min-height", "40em");
					$("#formStage").html("Basic Details")
				}
			if (currentIndex === 0 && $("#mainCustomerType").val()==="INDIVIDUAL"){
					$(".content").css("min-height", "64em");
					$("#formStage").html("Basic Details")
				}
			if (currentIndex === 0 && $("#mainCustomerType").val()==="OTHER"){
					$(".content").css("min-height", "30em");
					$("#formStage").html("Basic Details")
				}
			if (currentIndex === 2){
				$(".content").css("min-height", "32em");
				$("#formStage").html("Location Details")
			}
			if (currentIndex === 3){
				$(".content").css("min-height", "32em");
				$("#formStage").html("Employment Details")
			}
			if (currentIndex === 4){
				$(".content").css("min-height", "28em");
				$("#formStage").html("Spouse Details")
			}
			if (currentIndex === 5){
				$(".content").css("min-height", "28em");
				$("#formStage").html("Next Of Kin Details")
			}
			if (currentIndex === 6){
				$(".content").css("min-height", "30em");
				$("#formStage").html("Attachments")
			}

			if (currentIndex === 7){
				$(".content").css("min-height", "8em");
				$("#formStage").html("Finish")
			}
               // Used to skip the "Warning" step if the user is old enough.
               if ((currentIndex === 3 || currentIndex === 4|| currentIndex === 5) && priorIndex<currentIndex && $("#mainCustomerType").val() != "INDIVIDUAL")
               {
                   form.steps("next");
               }
               // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
               if ((priorIndex === 4 || priorIndex ===5|| priorIndex === 6) && priorIndex>currentIndex && $("#mainCustomerType").val() != "INDIVIDUAL")
               {
                   form.steps("previous");
               }
		},
		onFinishing: function (event, currentIndex)
		{
			//form.validate().settings.ignore = ":disabled";
			return form.valid();
		},
		onFinished: function (event, currentIndex)
		{
			$("#registration").submit();
			//alert("Submitted!");
		}
	}).validate({
		errorPlacement: function errorPlacement(error, element) { element.before(error); },
		rules: {
			confirm: {
				equalTo: "#password-2"
			}
		}
	});

});