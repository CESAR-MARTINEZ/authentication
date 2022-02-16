package com.dai.authentication.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dai.authentication.domain.Role;
import com.dai.authentication.domain.Usuario;
import com.dai.authentication.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthApi {

	private final UserService userService;

	@GetMapping({ "/usuarios" })
	public ResponseEntity<List<Usuario>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping({ "/roles" })
	public ResponseEntity<List<Role>> getRoles() {
		return ResponseEntity.ok().body(userService.getRoles());
	}
	
	@PostMapping({ "/usuario/save" })
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}

	@PostMapping({ "/role/save" })
	public ResponseEntity<Role> saveUser(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}

	@PostMapping({ "/role/addtouser" })
	public ResponseEntity<?> saveRole(@RequestBody RoleToUserForm role) {
//		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		userService.addRoleToUser(role.getUserName(), role.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	
}

@Data
class RoleToUserForm{
	private String userName;
	private String roleName;
}