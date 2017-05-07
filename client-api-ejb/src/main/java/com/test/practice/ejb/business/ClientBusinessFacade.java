package com.test.practice.ejb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.test.practice.ejb.persistence.dao.ClientDAO;
import com.test.practice.ejb.persistence.entity.Client;

@Stateless
public class ClientBusinessFacade {

	@EJB
	private ClientDAO clientDAO;

	public List<Client> retrieveAllClients() {
		return this.clientDAO.getAllClients();
	}

	public void createOrUpdateClient(Client client) {
		Client existenClient = this.clientDAO.getClient(client.getId());
		if (existenClient == null) {
			this.clientDAO.updateClient(client);
		} else {
			this.clientDAO.saveClient(client);
		}

	}

	@PostConstruct
	public void postConstruc() {
		System.out.println("---------------------");
	}
}
