package com.zonesoft.reference.keycloak;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                //.requestMatchers("/public").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();

       return  httpSecurity.build();
    }
    
    @Bean
    public CustomPrincipalExtractor principalExtractor() {
        return new CustomPrincipalExtractor();
    }

    @Bean
    public CustomAuthoritiesExtractor authoritiesExtractor() {
        return new CustomAuthoritiesExtractor();
    }    
}
