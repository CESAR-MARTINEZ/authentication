package com.dai.authentication.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dai.authentication.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	List<User> findAll();
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	
}
