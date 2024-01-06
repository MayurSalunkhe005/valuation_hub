package com.valuation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuation.model.Client;
import com.valuation.service.ClientService;

@RestController
public class ClientController {

	
	@Autowired
	ClientService clientService;

	public void m1(){
		int i = 10;
		int j= 20;
	}

	@PostMapping("/addclient")
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}
	
	@GetMapping("/get_client_by_id/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		return clientService.getClientById(id);
	}
	@GetMapping("/get_Client_By_FirstName/{firstName}")
	public Client getClientByFirstName(@PathVariable String firstName)  {
		return clientService.getClientByFirstName(firstName);

	}
	
	@DeleteMapping("/delete_client_by_id/{id}")
	public String deleteClientById(@PathVariable("id") Long id) {
		return clientService.deleteClientById(id);
		
	}
	
	@PutMapping("/update_client_details/{id}")
	public String updateClient(@PathVariable Long id, @RequestBody Client client  ) {
		return clientService.updateClientDetails(id, client);
		
	}
	
}
