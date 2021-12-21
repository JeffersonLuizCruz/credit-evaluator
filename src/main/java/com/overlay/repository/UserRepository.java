package com.overlay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overlay.model.entity.AccessUser;

@Repository
public interface UserRepository extends JpaRepository<AccessUser, Long>{
	
	Optional<AccessUser> findByEmail(String email);

}
