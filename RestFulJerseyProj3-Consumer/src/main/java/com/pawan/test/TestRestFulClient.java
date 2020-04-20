package com.pawan.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TestRestFulClient {

	public static void main(String[] args) {

		try {
			String URI = "http://localhost:5050/RestFulJerseyProducerProj3/";
			// String PATH = "/rest/emp/m2";
			// String PATH = "/rest/product/m2";
			// String PATH = "/rest/product";
			String PATH = "/rest/emp";
			Client c = ClientBuilder.newClient();

			WebTarget t = c.target(URI).path(PATH);
			Invocation.Builder builder = t.request();
			// Response res = builder.get();
			// Response res = builder.delete();
			// Response res = builder.post(Entity.text("none"));
			Response res = builder.delete();
			// Response res = builder.put(Entity.text("none"));
			System.out.println(res.getStatus());
			System.out.println(res.getStatusInfo());
			System.out.println(res.readEntity(String.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
