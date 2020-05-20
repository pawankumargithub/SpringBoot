package com.pawan.mvc.cmd;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class PatientCommand {

	private Integer patId;

	@NotEmpty(message = "name must be entered")
	private String patName;
	@NotNull(message = "age must be entered")
	@Range(min = 1,max = 100,message = "age must be between min 1 and max 100")
	private Integer patAge;
	@NotEmpty(message = "name must be entered")
	@Length(min = 3,max = 12,message = "hospital chars shoud be min 3 and max 12")
	private String hospital;
	@NotEmpty(message = "hospital name must be entered")
	private String location;
	
	private String vflag="no";
}
