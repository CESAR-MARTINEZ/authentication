package com.dai.authentication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dai.authentication.domain.Role;
import com.dai.authentication.domain.Usuario;
import com.dai.authentication.repo.RoleRepo;
import com.dai.authentication.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;

	@Override
	public Usuario saveUser(Usuario user) {
		log.info("Guardando un nuevo usuario {} en la base.", user.getNombre());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Guardando un nuevo rol {} en la base.", role.getNombre());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Agregando un nuevo role {} al usuario {} en la base.", roleName, username);
		Usuario user = userRepo.findByUsername(username);
		Role role = roleRepo.findByNombre(roleName);
		user.getRoles().add(role);
	}

	@Override
	public Usuario getUser(String username) {
		log.info("Buscando un usuario {} en la base.", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<Usuario> getUsers() {
		log.info("Buscando un todos los usuarios en la base.");
		return userRepo.findAll();
	}

	@Override
	public List<Role> getRoles() {
		log.info("Buscando un todos los roles en la base.");
		return roleRepo.findAll();
	}

}
