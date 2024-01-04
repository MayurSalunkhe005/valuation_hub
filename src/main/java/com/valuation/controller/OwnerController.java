package com.valuation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valuation.model.Owner;
import com.valuation.service.OwnerService;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;

	@PostMapping("/addowner")
	private Owner addOwner(@RequestBody Owner owner) {
		return ownerService.addowner(owner);

	}

	@GetMapping("/get_owner_by_id/{id}")
	private Owner getOwner(@PathVariable("id") Long id) {
		return ownerService.getownerbyid(id);
	}

	@DeleteMapping("/delete_by_id/{id}")
	private String deleteOwnerById(@PathVariable("id") Long id) {
		return ownerService.deletebyid(id);
	}

	@PutMapping("/updateownerdetails/{id}")
	private String updateOwner(@PathVariable Long id,@RequestBody Owner owner) {
		return ownerService.updateOwnerDetails(id,owner);

	}
}
