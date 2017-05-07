package com.test.practice.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.practice.ejb.business.ClientBusinessFacade;
import com.test.practice.ejb.persistence.entity.Client;

@SuppressWarnings("serial")
public class ClientFormServlet extends HttpServlet {

	@EJB
	private ClientBusinessFacade clientBusinessFacade;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		Client client = new Client(id, name, age, address);
		this.clientBusinessFacade.createOrUpdateClient(client);
		super.doPost(req, resp);
	}

}
