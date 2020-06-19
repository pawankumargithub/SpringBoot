$(document).ready(function() {

	$("#uomTypeError").hide();
	$("#uomModelError").hide();
	$("#descriptonError").hide();
	var uomTypeError = false;
	var uomModelError = false;
	var descriptonError = false;

	$("#umoType").change(function() {

		validate_umoType();

	});
	$("#uomModel").keyup(function() {

		validate_uomModel();

	});

	$("#description").keyup(function() {

		validate_description();

	});
	function validate_umoType() {
		var val = $("#umoType").val();
		if (val == '') {
			$("#uomTypeError").html("plz enter uom type");
			$("#uomTypeError").css("color", "red");
			$("#uomTypeError").show();
			uomTypeError = false;

		} else {
			$("#uomTypeError").hide();
			uomTypeError = true;
		}

		return uomTypeError;
	}
	function validate_uomModel() {
		var val = $("#uomModel").val();
		var exp = /^[A-Z]{3,8}$/;
		if (val == '') {
			$("#uomModelError").html("plz enter uom model");
			$("#uomModelError").css("color", "red");
			$("#uomModelError").show();
			uomModelError = false;

		} else if (!exp.test(val)) {
			$("#uomModelError").html("uom model must be 3 to 8 char");
			$("#uomModelError").css("color", "red");
			$("#uomModelError").show();
			uomModelError = false;

		} else {
			$("#uomModelError").hide();
			uomModelError = true;
		}

		return uomModelError;
	}

	function validate_description() {

		var val = $("#description").val();
		if (val == '') {
			$("#descriptonError").html("enter description");
			$("#descriptonError").css("color", "red");
			$("#descriptonError").show();
			descriptonError = false;
		} else {
			$("#descriptonError").hide();
			descriptonError = true;

		}
		return descriptonError;
	}
	$("#uomForm").submit(function() {
		validate_description();
		validate_uomModel();
		validate_umoType();

		if (uomTypeError && uomModelError && descriptonError)

			return true;
		else
			return false;

	});

});