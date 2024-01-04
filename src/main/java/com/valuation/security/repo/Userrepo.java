package com.valuation.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valuation.security.entity.User;

public interface Userrepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}
