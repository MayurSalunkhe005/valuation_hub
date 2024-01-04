package com.valuation.security.config;

import java.util.regex.Pattern;

import javax.annotation.security.PermitAll;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private final AuthenticationProvider authenticationProvider;
	private final JwtAuthenticationFilter jwtAuthFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		//String pattern;
		//AuthenticationProvider authenticationProvider = null;
		//Filter jwtAuthFilter = null;
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("/api/v1/auth/**")
		//.antMatchers("/api/v1/auth/**")
		.permitAll()
		.anyRequest() 
		.authenticated() 
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}

}
