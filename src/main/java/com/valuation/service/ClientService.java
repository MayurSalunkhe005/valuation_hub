package com.valuation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuation.Repository.ClientRepo;
import com.valuation.model.Client;

@Service
public class ClientService {

	@Autowired
	static ClientRepo clientRepo;

	public Client addClient(Client client) {
		return clientRepo.save(client);
	}

	public Client getClientById(Long id) {
		return clientRepo.findById(id).orElseThrow();
	}

	public String deleteClientById(Long id) {
		clientRepo.deleteById(id);
		return "client " + id + " has been deleted successfully";
	}

	public Client getClientByFirstName(String first_Name) {

		return clientRepo.findByfirstName(first_Name);
	}

	public String updateClientDetails(Long id, Client client) {
		Client updateClient = clientRepo.findById(id).orElseThrow();
		updateClient.setFirstName(client.getFirstName());
		updateClient.setLastName(client.getLastName());
		updateClient.setPhNo(client.getPhNo());
		updateClient.setEmailId(client.getEmailId());
		updateClient.setAddress(client.getAddress());
		clientRepo.save(updateClient);
		return "client updated";
	}

}