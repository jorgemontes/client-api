package com.test.practice.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.practice.ClientDAO;
import com.test.practice.persistence.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/client")
@Api(value = "/client")
@Stateless
public class ClientService {

	@EJB
	private ClientDAO clientDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get All clients")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "UhOh") })
	public List<Client> getAllClients() {
		return this.clientDAO.getAllClients();
	}

}
