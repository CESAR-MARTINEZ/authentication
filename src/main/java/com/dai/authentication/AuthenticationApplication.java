package com.dai.authentication;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dai.authentication.domain.Role;
import com.dai.authentication.domain.Usuario;
import com.dai.authentication.service.UserService;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(1,"ROLE_USER", new ArrayList<>()));
			userService.saveRole(new Role(2,"ROLE_MANAGER", new ArrayList<>()));
			userService.saveRole(new Role(3,"ROLE_ADMIN", new ArrayList<>()));
			userService.saveRole(new Role(4,"ROLE_SUPER_ADMIN", new ArrayList<>()));
			
			userService.saveUser(new Usuario(1,"Cesar Martinez","cesarin","1234",new ArrayList<>()));
			userService.saveUser(new Usuario(2,"Paulo Martinez","paulito","1234",new ArrayList<>()));
			userService.saveUser(new Usuario(3,"Gabriel Martinez","gabo","1234",new ArrayList<>()));
			userService.saveUser(new Usuario(4,"Sahian Martinez","sayayina","1234",new ArrayList<>()));
		
			userService.addRoleToUser("cesarin", "ROLE_USER");
			userService.addRoleToUser("cesarin", "ROLE_MANAGER");
			userService.addRoleToUser("cesarin", "ROLE_ADMIN");
			userService.addRoleToUser("paulito", "ROLE_MANAGER");
			userService.addRoleToUser("gabo", "ROLE_ADMIN");
			userService.addRoleToUser("sayayina", "ROLE_SUPER_ADMIN");
		};
	}

}
