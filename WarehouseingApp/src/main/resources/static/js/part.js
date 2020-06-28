$(document).ready(function() {


	$("#partCodeError").hide();
	$("#partWdthError").hide();
	$("#partLengthError").hide();
	$("#partHeightError").hide()
	var partCodeError = false;
	var partWdthError=false;
	var partLengthError=false;
	var partHeightError=false;

	$("#partCode").keyup(function(){

		validate_partCode();

	});
	$("#partWdth").keyup(function(){

		validate_partWdth();

	});
	$("#partLen").keyup(function(){

		validate_partLen();
	});
	$("#partHgh").keyup(function(){

		validate_partHgh();

	});
	function validate_partCode(){
		var val=$("#partCode").val();
		var exp = /^[a-z]{6,8}$/;
		if(val==''){
			$("#partCodeError").show();
			$("#partCodeError").html("please enter part code");
			$("#partCodeError").css("color","red");
			partCodeError = false;

		}
		else if(!exp.test(val)){
			$("#partCodeError").show();
			$("#partCodeError").html("please provide 6 to 8 char atleast (small latter only)");
			$("#partCodeError").css("color","red");
			partCodeError = false;
		}
		else{
			$("#partCodeError").hide();
			partCodeError = true;

		}

		return partCodeError;
	}

	function validate_partWdth(){
		var val=  $("#partWdth").val();
		if(val==''){
			$("#partWdthError").show();
			$("#partWdthError").html("please enter part width");
			$("#partWdthError").css("color","red");
			partWdthError=false;

		}
		else{

			$("#partWdthError").hide();
			partWdthError=true;
		}
		return partWdthError;
	}
	function validate_partLen(){

		var val=$("#partLen").val();

		if(val==''){
			$("#partLengthError").show();
			$("#partLengthError").html("please enter part length");
			$("#partLengthError").css("color","red");
			partLengthError=false;
		}
		else{
			partLengthError=true;
			$("#partLengthError").hide();
		}
		return partLengthError;
	}
	function validate_partHgh(){

		var val=$("#partHgh").val();
		if(val==''){
			$("#partHeightError").show();
			$("#partHeightError").html("please enter part height");
			$("#partHeightError").css("color","red");

			partHeightError=false;
		}
		else{
			$("#partHeightError").hide();
			partHeightError=true;
		}
		return partHeightError;
	}


	$("#partForm").submit(function(){
		validate_partCode();
		validate_partWdth();
		validate_partLen();
		validate_partHgh();

		if(partCodeError && partWdthError && partLengthError && partHeightError )
			return true;
		else return false;

	});
});
$(document).ready(function(){
	$("#partCode").change(function(){
		
		$.ajax({
			
			url:'partCode',
			data:{"code":$("#partCode").val()},
			success:function(res){
				
				if(res!=""){
					$("#partCodeError").show();
					$("#partCodeError").html(res);
					$("#partCodeError").css("color","red");
				}
				else{
					$("#partCodeError").hide();
				}
				
			}	
			
		})
		
	})
	
});