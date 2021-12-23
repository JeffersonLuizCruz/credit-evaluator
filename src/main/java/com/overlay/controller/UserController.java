package com.overlay.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.overlay.model.dto.UserLoginResponseDTO;
import com.overlay.model.entity.AccessUser;
import com.overlay.security.JwtManager;
import com.overlay.service.UserService;

public class UserController {
	
	@Autowired AuthenticationManager authManager;
	@Autowired private UserService userService;
	@Autowired private JwtManager jwtManager;
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDTO> login(@RequestBody @Valid AccessUser user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		Authentication auth = authManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		User userSpring = (User) auth.getPrincipal();
		
		String email = userSpring.getUsername();
		List<String> roles = userSpring.getAuthorities()
										.stream()
										.map(authority -> authority.getAuthority())
										.collect(Collectors.toList());
				
		return ResponseEntity.ok(jwtManager.createToken(email, roles));
	}

}
