package com.valuation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuation.Repository.OwnerRepo;
import com.valuation.model.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepo ownerRepo;

	Owner owner;

	public Owner addowner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner getownerbyid(Long id) {
		return ownerRepo.findById(id).orElse(null);
	}

	public String deletebyid(Long id) {
		ownerRepo.deleteById(id);
		return "Owner Of" + id + "deleted successfully";

	}

	public String updateOwnerDetails(Long id, Owner owner) {
		Owner updateOwner = ownerRepo.findById(id).orElseThrow();
		updateOwner.setFistName(owner.getFistName());
		updateOwner.setLastName(owner.getLastName());
		updateOwner.setPhno(owner.getPhno());
		updateOwner.setEmailId(owner.getEmailId());
		updateOwner.setAddress(owner.getAddress());
		ownerRepo.save(updateOwner);
		return "record updated";
	}
}