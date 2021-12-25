package com.overlay.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.overlay.exception.NotFoundException;
import com.overlay.model.entity.AccessUser;
import com.overlay.repository.UserRepository;

public class AccessManager {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public boolean isOwner(Long id) {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<AccessUser> result = userRepository.findByEmail(email);
		
		if(!result.isPresent()) throw new NotFoundException("There are not user with email = " + email);
		
		AccessUser user = result.get();
		
		return user.getId() == id;
	}

}
