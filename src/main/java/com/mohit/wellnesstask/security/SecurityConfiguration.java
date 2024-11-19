package com.mohit.wellnesstask.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /*
     * it is for to implement basic authentication using spring security
     * 
     */
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        
       return http.csrf(customizer->customizer.disable())
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(request->request
            .requestMatchers("/login").permitAll()// for login
            .anyRequest().authenticated())// any other request except login should be authenticated
            .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }
}
