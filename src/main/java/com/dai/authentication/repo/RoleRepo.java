package com.dai.authentication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dai.authentication.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Optional<Role> findById(Long id);
	
}
