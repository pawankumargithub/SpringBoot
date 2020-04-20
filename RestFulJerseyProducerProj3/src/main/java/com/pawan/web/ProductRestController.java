package com.pawan.web;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/product")
public class ProductRestController {

	
	
	@GET
	public String m1() {
		return "product-GET-m1()";
	}
	
	@GET
	@Path("/m2")
	public String m2() {
		return "product-GET-with Path-m2()";
	}
	@POST
	@Path("/m3pro")
	public String m3() {
		return "product-POST";
	}
	@DELETE
	public String m4() {
		return "product-DELETE";
	}
	@PUT
	public String m5() {
		return "product-PUT";
	}
}
