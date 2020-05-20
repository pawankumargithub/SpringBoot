function validate(frm){
	alert("client side validation happening")
	document.getElementById("patNameErr").innerHTML="";
	document.getElementById("patAgeErr").innerHTML="";
	document.getElementById("patLocationErr").innerHTML="";
	document.getElementById("patHospitalErr").innerHTML="";
	
	
	// read form data
	
	let name=frm.patName.value;
	let age=frm.patAge.value;
	let hsptl=frm.hospital.value;
	let loc=frm.location.value;
	let flag=false;
	
	//validation
	
	if(name==""){
		document.getElementById("patNameErr").innerHTML="<b>patient name is mandatory</b>";
		frm.patName.focus();
		flag=true;
	}
	
	if(loc==""){
		document.getElementById("patLocationErr").innerHTML="<b>patient location is mandatory</b>";
	
		flag=true;
	}
	if(age==""){
		document.getElementById("patAgeErr").innerHTML="<b>patient age is mandatory</b>";
		
		flag=true;
	}
	
	else if(isNaN(age)){
		document.getElementById("patAgeErr").innerHTML="<b>patient age must be integer</b>";
	
		flag=true;
	}
	else if(age<1||ag>100){
		document.getElementById("patAgeErr").innerHTML="<b>patient age must be between 1 to 100</b>";
		
		flag=true;
	}
	if(hsptl==""){
		document.getElementById("patHospitalErr").innerHTML="<b>patient hospital is mandatory</b>";
	
		flag=true;
	}
	else if(hsptl.length<3||hsptl.length>12){
		document.getElementById("patHospitalErr").innerHTML="<b>hospital char shoud be min 3 and max 12</b>";
		
		flag=true;
	}
	frm.vflag.value="yes";
		if(flag)
			return false
			else
	return true;
	
	
}