package com.test.practice.web.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class JerseyService {
	@GET
	public String getMsg() {
		return "Hello World !! - Jersey 2";
	}
}