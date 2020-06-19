$(document)
		.ready(
				function() {

					$("#orderModeError").hide();
					$("#orderCodeError").hide();
					$("#orderTypeError").hide();
					$("#orderAcptError").hide();
					$("#descriptionError").hide();
					var orderModeError = false;
					var orderCodeError = false;
					var orderTypeError = false;
					var orderAcptError = false;
					var descriptionError = false;

					$('input [type="radio"] [name="orderMode"]').change(
							function() {
								validate_orderMode();

							});
					$("#orderCode").keyup(function() {

						validate_orderCode();

					});
					$("#orderType").change(function() {

						validate_orderType();

					});
					$('input[type="checkbox"][name="orderAccept"]').change(
							function() {
								validate_orderAcpt();
							});
					$("#description").keyup(function() {

						validate_description();

					});

					function validate_orderMode() {

						var len = $('input[type="radio"][name="orderMode"]:checked').length;

						if (len == 0) {
							$("#orderModeError").html(
									"plz choose one order mode");
							$("#orderModeError").css("color", "red");
							$("#orderModeError").show();

							orderModeError = false;
						} else {
							$("#orderModeError").hide();
							orderModeError = true

						}
						return orderModeError;
					}
					function validate_orderCode() {

						var val = $("#orderCode").val();
						var exp = /^[A-Z]{4,25}$/;
						if (val == '') {
							$("#orderCodeError").html(
									"enter order code in upper case only");
							$("#orderCodeError").css("color", "red");
							$("#orderCodeError").show();
							orderCodeError = false;

						} else if (!exp.test(val)) {

							$("#orderCodeError").html(
									"must be 4 to 25 chars(upper case)");
							$("#orderCodeError").css("color", "red");
							$("#orderCodeError").show();
							orderCodeError = false;
						} else {
							$("#orderCodeError").hide();
							orderCodeError = true;

						}

						return orderCodeError;
					}

					function validate_orderType() {

						var val = $("#orderType").val();
						if (val == '') {

							$("#orderTypeError").html(
									"please select one order type");
							$("#orderTypeError").css("color", "red");

							$("#orderTypeError").show();
							orderTypeError = false;
						} else {

							$("#orderTypeError").hide();
							orderTypeError = true;
						}
						return orderTypeError;
					}
					function validate_orderAcpt() {

						var len = $('input[type="checkbox"][name="orderAccept"]:checked').length;

						if (len == 0) {
							$("#orderAcptError").html(
									"please choose atleast one option");
							$("#orderAcptError").css("color", "red");
							$("#orderAcptError").show();

							orderAcptError = false;
						} else {
							$("#orderAcptError").hide();
							orderAcptError = true;

						}
						return orderAcptError;
					}
					function validate_description() {

						var val = $("#description").val();
						if (val.length < 5 || val.length > 150) {
							$("#descriptionError")
									.html(
											"Please Enter Description Between 5 to 150");
							$("#descriptionError").css("color", "red");
							$("#descriptionError").show();
							descriptionError = false;
						} else {

							$("#descriptionError").hide();
							descriptionError = true;
						}
						return descriptionError;
					}

					$("#orderMethodForm").submit(
							function() {

								validate_orderMode();
								validate_orderCode();
								validate_orderType();
								validate_orderAcpt();
								validate_description();
								if (orderModeError && orderCodeError
										&& orderTypeError && orderAcptError
										&& descriptionError)
									return true;
								else
									return false;
							});

				});