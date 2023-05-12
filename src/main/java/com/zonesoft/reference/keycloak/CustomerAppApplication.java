package com.zonesoft.reference.keycloak;


//import org.keycloak.KeycloakPrincipal;
//import org.keycloak.KeycloakSecurityContext;
//import org.keycloak.representations.AccessToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
//import java.util.Set;

@SpringBootApplication
public class CustomerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppApplication.class, args);
	}
}

@RestController
class CustomerController {

	@GetMapping(path = "/hello")
	public String helloKeycloak(){
		return "Hello from Keycloak secure server";

	}
// Current user: demo - Roles: [offline_access, default-roles-spring-realm, uma_authorization, Users]
	@GetMapping("/user")
	public String getCurrentUser(Authentication /*authentication*/ principal) {
//		KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
//		AccessToken accessToken = keycloakSecurityContext.getToken();
//		String currentUser = accessToken.getPreferredUsername();
		String currentUser = principal.getName();
//		Set<String> roles = accessToken.getRealmAccess().getRoles();
		Collection<? extends GrantedAuthority> roles = principal.getAuthorities();
		return "Current user: " + currentUser + " - Roles: " + roles;
	}
}
