package com.overlay.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.overlay.controller.exceptions.UserNameNotFoundExecption;
import com.overlay.model.entity.AccessUser;
import com.overlay.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	private static String NOT_FOUND_EXECPTION = "Não existe usuário com email: %s";
	
	@Autowired private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AccessUser> resultUser = userRepository.findByEmail(username);
		
		if(!resultUser.isPresent()) throw new UserNameNotFoundExecption(String.format(NOT_FOUND_EXECPTION, username));
		
		AccessUser user = resultUser.get();
		
		List<GrantedAuthority> grantedAuthority = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

		
		User userDetails = new User(user.getEmail(), user.getPassword(), grantedAuthority);
		
		return userDetails;
	}

}
