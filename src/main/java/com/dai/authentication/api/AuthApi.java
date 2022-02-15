package com.dai.authentication.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthApi {

	@GetMapping({"/saludo"})
	public String saludar() {
		return "Hola mundo";
	}
}
