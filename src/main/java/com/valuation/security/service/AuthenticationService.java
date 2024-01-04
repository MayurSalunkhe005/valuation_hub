package com.valuation.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valuation.security.entity.AuthenticationRequest;
import com.valuation.security.entity.AuthenticationResponse;
import com.valuation.security.entity.Register;

import com.valuation.security.entity.Role;
import com.valuation.security.entity.User;
import com.valuation.security.repo.Userrepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final Userrepo userrepo;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(Register request) {
		User user = User.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.passward(passwordEncoder.encode(request.getPassword()))
				.role(Role.User)
				.build();
		userrepo.save(user);
		String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = userrepo.findByEmail(request.getEmail()).orElseThrow();
		String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

}
