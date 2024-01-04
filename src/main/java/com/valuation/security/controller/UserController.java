package com.valuation.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valuation.security.entity.User;
import com.valuation.security.repo.Userrepo;
@RestController
public class UserController {
	 @Autowired
	Userrepo userrepo;

	 @PostMapping("/user")
		public User addUser(@RequestBody User user) {
			return userrepo.save(user);
	 }


}
