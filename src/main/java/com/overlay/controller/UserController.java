package com.overlay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.overlay.security.JwtManager;
import com.overlay.service.UserService;

public class UserController {
	
	@Autowired AuthenticationManager authManager;
	@Autowired private UserService userService;
	@Autowired private JwtManager jwtManager;
	

}
