package com.pawan.web;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {

	@GET
	public String m1() {
		return "emp-GET-m1()";
	}
	
	@GET
	@Path("/m2")
	public String m2() {
		return "emp-GET-with Path-m2()";
	}
	@POST
	public String m3() {
		return "emp-POST";
	}
	@DELETE
	public String m4() {
		return "emp-DELETE";
	}
	@PUT
	public String m5() {
		return "emp-PUT";
	}
}  
