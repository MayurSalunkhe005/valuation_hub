package com.valuation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valuation.model.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

	public Client findByfirstName(String firstName);


	//public Client findByfirst_Name(String first_Name);
}
