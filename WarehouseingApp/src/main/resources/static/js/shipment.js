$(document)
		.ready(
				function() {
					$("#shipmentModeError").hide();
					$("#shipmentCodeError").hide();
					$("#enableShipmentError").hide();
					$("#shipmentGradeError").hide();
					$("#descriptionError").hide();

					var shipmentModeError = false;
					var shipmentCodeError = false;
					var enableShipmentError = false;
					var shipmentGradeError = false;
					var descriptionError = false;
					$("#shipmentMode").change(function() {

						validate_shipmentMode();

					});
					$("#shipmentCode").keyup(function() {

						validate_shipmentCode();

					});
					$("#enableShipment").change(function() {

						validate_enableShipment();
					});

					$('input[type="radio"][name="shipmentGrade"]').change(
							function() {
								validate_shipmentGrade();
							});
					$("#description").keyup(function() {

						validate_description();

					});
					function validate_shipmentMode() {

						var val = $("#shipmentMode").val();
						if (val == '') {

							$("#shipmentModeError").show();
							$("#shipmentModeError").html(
									"please select shipment mode");
							$("#shipmentModeError").css("color", "red");

							shipmentModeError = false;

						} else {
							$("#shipmentModeError").hide();

							shipmentModeError = true;
						}
						return shipmentModeError;
					}
					function validate_shipmentCode() {

						var val = $("#shipmentCode").val();
						var exp = /^[A-Z]{4,8}$/;
						if (val == '') {
							$("#shipmentCodeError").show();
							$("#shipmentCodeError").html(
									"please select shipment mode");
							$("#shipmentCodeError").css("color", "red");

							shipmentCodeError = false;

						} else if (!exp.test(val)) {
							$("#shipmentCodeError").show();
							$("#shipmentCodeError").html(
									"must be 4 to 8 char only");
							$("#shipmentCodeError").css("color", "red");

							shipmentCodeError = false;

						} else {
							$("#shipmentCodeError").hide();
							shipmentCodeError = true;

						}
						return shipmentCodeError;
					}

					function validate_enableShipment() {

						var val = $("#enableShipment").val();

						if (val == '') {

							$("#enableShipmentError").show();
							$("#enableShipmentError").html(
									"please enable shipment");
							$("#enableShipmentError").css("color", "red");

							enableShipmentError = false;

						} else {

							$("#enableShipmentError").hide();
							enableShipmentError = true;
						}

						return enableShipmentError;
					}

					function validate_shipmentGrade() {
						var len = $('input[type="radio"][name="shipmentGrade"]:checked').length;
						if (len == 0) {
							$("#shipmentGradeError").show();
							$("#shipmentGradeError").html(
									"Choose One <b>Shipment Grade</b>");
							$("#shipmentGradeError").css("color", "red");
							shipmentGradeError = false;
						} else {
							$("#shipmentGradeError").hide();
							shipmentGradeError = true;
						}
						return shipmentGradeError;
					}
					function validate_description() {

						var val = $("#description").val();
						if (val.length < 10 || val.length > 150) {

							$("#descriptionError").show();
							$("#descriptionError").html("enter description");
							$("#descriptionError").css("color", "red");
							descriptionError = false;

						} else {
							$("#descriptionError").hide();
							descriptionError = true;
						}
						return descriptionError;
					}

					$("#shipmentForm").submit(
							function() {
								validate_shipmentMode();
								validate_shipmentCode();
								validate_enableShipment();
								validate_shipmentGrade()
								validate_description();
								if (shipmentModeError && shipmentCodeError
										&& enableShipmentError
										&& shipmentGradeError
										&& descriptionError)
									return true;
								else
									return false;

							});
				});