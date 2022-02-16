package com.dai.authentication.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dai.authentication.domain.Usuario;

public interface UserRepo extends JpaRepository<Usuario, Long> {
	List<Usuario> findAll();
	Usuario findByUsername(String username);
	Usuario findByUsernameAndPassword(String username, String password);
	
}
