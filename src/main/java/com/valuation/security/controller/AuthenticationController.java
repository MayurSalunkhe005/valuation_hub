package com.valuation.security.controller;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuation.security.entity.AuthenticationRequest;
import com.valuation.security.entity.AuthenticationResponse;
import com.valuation.security.entity.Register;

import com.valuation.security.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {
	
	@Autowired
	private final AuthenticationService service;
	
    @PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register (
			@RequestBody Register request
			) {
				return ResponseEntity.ok(service.register(request));
		
	}
    @PostMapping("/authenticate")
   	public ResponseEntity<AuthenticationResponse> authenticate (
   			@RequestBody AuthenticationRequest request
   			) {
				return ResponseEntity.ok(service.authenticate(request));
   		
   	}


}
