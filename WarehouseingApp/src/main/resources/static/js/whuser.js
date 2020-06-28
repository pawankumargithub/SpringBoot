$(document).ready(function() {
	// ---extra validations work --//
	// --Auto Fill for User For---

	$('input[type="radio"][name="userType"]').change(function() {
		autoFillUserFor();
	});

	function autoFillUserFor() {
		var val = $('input[type="radio"][name="userType"]:checked').val();
		if (val == 'Vendor') {
			$("#userFor").val('Purchase');
		} else if (val == 'Customer') {
			$("#userFor").val('Sale');
		}
	}
	// ifOther Text Input
	$("#userIdType").change(function() {
		var val = $("#userIdType").val();
		if (val == 'OTHER') {
			$("#ifother").removeAttr("readOnly");
		} else {
			$("#ifother").attr("readOnly", "true");
			$("#ifother").val("");
		}
	});

});

$(document).ready(function() {

	$("#userMailError").hide();

	$("#userMailError").hide();
	$("#idNumberError").hide();
	$("#userContactError").hide();
	var userMailError = false;
	var userMailError = false;
	var idNumberError = false;
	var userContactError = false;

	$("#userCode").keyup(function() {
		validate_userCode();

	});
	$("#userMail").keyup(function() {

		validate_userMail();
	});
	$("#idNumber").keyup(function() {
		validate_idNumber();

	});
	$("#userContact").keyup(function() {
		validate_userContact();

	});
	function validate_userCode() {
		var val = $("#userCode").val();
		if (val == '') {
			$("#userCodeError").show();
			$("#userCodeError").html("plz enter user code");
			$("#userCodeError").css("color", "red");
			userCodeError = false;

		} else {
			$("#userCodeError").hide();
			userCodeError = true;

		}
		return userCodeError;

	}
	function validate_userMail() {

		var val = $("#userMail").val();
		if (val == '') {
			$("#userMailError").show();
			$("#userMailError").html("plz enter user email");
			$("#userMailError").css("color", "red");
			var userMailError = false;

		} else {
			$("#userMailError").hide();
			var userMailError = true;
		}
		return
		

		userMailError;
	}
	function validate_idNumber() {

		var val = $("#idNumber").val();
		if (val == '') {

			$("#idNumberError").show();
			$("#idNumberError").html("plz enter id");
			$("#idNumberError").css("color", "red");
			idNumberError = false;
		}

		else {
			$("#idNumberError").hide();
			idNumberError = true;
		}
		return idNumberError;
	}
	function validate_userContact()
	{

		var val = $("#userContact").val();
		if (val == '') {
			$("#userContactError").show();
			$("#userContactError").html("enter user contact");
			$("#userContactError").css("color", "red");
			userContactError = false;
		} else {
			$("#userContactError").hide();
			userContactError = true;

		}
		return userContactError;
	}
	$("#whUserTypeForm").submit(function() {
		validate_userCode();
		validate_userMail();
		validate_idNumber();
		validate_userContact();
		if (userCodeError && userMailError && idNumberError && userContactError)
			return true;
		else
			return false;
	})

});