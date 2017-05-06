package com.test.practice.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.practice.ejb.persistence.entity.Client;

@Stateless
public class ClientDAO {

	@PersistenceContext(unitName = "clientPersistenceUnit")
	private EntityManager entityManager;

	public void saveClient(Client client) {
		this.entityManager.persist(client);
	}

	public void updateClient(Client client) {
		this.entityManager.merge(client);
	}

	public Client getClient(String id) {
		return this.entityManager.find(Client.class, id);
	}

	public List<Client> getAllClients() {
		return this.entityManager.createQuery("from " + Client.class.getSimpleName()).getResultList();
	}

}
