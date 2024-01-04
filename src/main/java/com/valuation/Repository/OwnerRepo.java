package com.valuation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.valuation.model.Owner;
@Repository
public interface OwnerRepo extends JpaRepository<Owner,Long>{

	//Optional <Owner> findByemail_Id();

	

}

