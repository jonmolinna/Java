package com.project.project_monitoring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.project_monitoring.filter.JwtAuthFilter;
import com.project.project_monitoring.service.auth.AuthService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    // Seguridad de las rutas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desactivar CSRF ya que estamos trabajando con una API REST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/login").permitAll()
                // .requestMatchers(HttpMethod.GET, "/api/v1/group/**").authenticated()
                // .requestMatchers(HttpMethod.POST, "/api/v1/group/**").hasAuthority("admin")
                // .requestMatchers(HttpMethod.PUT, "/api/v1/group/**").hasAuthority("admin")
                // .requestMatchers(HttpMethod.DELETE, "/api/v1/group/**").hasAuthority("admin")
                // .requestMatchers(HttpMethod.POST, "/api/v1/users/**").hasAuthority("admin")
                // .requestMatchers(HttpMethod.GET, "/api/v1/users/all").hasAuthority("admin")
                // .requestMatchers(HttpMethod.GET, "/api/v1/users/{id}").authenticated()
                // .requestMatchers("/api/v1/group/**").hasAuthority("admin")
                .requestMatchers("/api/v1/users/**").authenticated()
                .anyRequest().authenticated() // protege las otras rutas
            )
            .sessionManagement(sess -> sess
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // no session
            )
            .authenticationProvider(authenticationProvider()) //Custom authentication provider
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return authenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AuthService();
    }

    // Config Password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


// @EnableGlobalMethodSecurity(prePostEnabled = true): 
// Esto habilita las expresiones de seguridad como @PreAuthorize.

// @EnableGlobalMethodSecurity(securedEnabled = true): 
// Esto habilita el uso de la anotación @Secured.