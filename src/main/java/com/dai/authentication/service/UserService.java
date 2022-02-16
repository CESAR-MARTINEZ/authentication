package com.dai.authentication.service;

import java.util.List;

import com.dai.authentication.domain.Role;
import com.dai.authentication.domain.Usuario;

public interface UserService {

	Usuario saveUser(Usuario user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	Usuario getUser(String username);

	List<Usuario> getUsers();
	
	List<Role> getRoles();

}
