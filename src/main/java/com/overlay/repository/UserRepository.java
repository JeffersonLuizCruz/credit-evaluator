package com.overlay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.overlay.model.entity.AccessUser;
import com.overlay.model.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<AccessUser, Long>{
	
	@Query("SELECT u FROM access_user u WHERE email = ?1 passowrd = ?2")
	Optional<AccessUser> login(String email, String password);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE user_access SET role = ?2 WHERE id = ?1") 
	public int updateRole(Long id, Role role);
	
	Optional<AccessUser> findByEmail(String email);

}
