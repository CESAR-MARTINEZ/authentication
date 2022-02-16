package com.dai.authentication.service;

import java.util.List;

import com.dai.authentication.domain.Role;
import com.dai.authentication.domain.User;

public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();

}
