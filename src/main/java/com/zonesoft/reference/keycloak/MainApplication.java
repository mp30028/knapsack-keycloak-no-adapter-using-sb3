package com.zonesoft.reference.keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}

@RestController
class MainController {

	@GetMapping(path = "/hello")
	public String helloKeycloak(){
		return "Hello from Keycloak secure server";

	}

	@GetMapping("/user")
	public String getCurrentUser(Authentication authentication) {
		String currentUser = authentication.getName();
		Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
		return "Current user: " + currentUser + " - Roles: " + roles;
	}
}
