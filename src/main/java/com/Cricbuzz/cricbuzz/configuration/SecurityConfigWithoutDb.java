//package com.Cricbuzz.cricbuzz.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.Customizer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(authorize -> authorize
////                        // Allow public access to all /api/v1/player endpoints
////                        .requestMatchers("/api/v1/player/**").hasRole("PUBLIC")
////                        // Any other request requires authentication
////                        .anyRequest().authenticated()
////                )
////                .formLogin(form -> form.permitAll()) // Optional: Provides a login form
////                .logout(logout -> logout.permitAll()); // Optional: Allows logout
////
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for API usage
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/api/v1/player/**").hasRole("PUBLIC")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults()); // Use HTTP Basic Authentication
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Define a single user with the PUBLIC role (in-memory for simplicity)
//        UserDetails publicUser = User.withUsername("Sid")
//                .password("{noop}Admin@123") // {noop} means no password encoding (for demo purposes)
//                .roles("PUBLIC")
//                .build();
//
//        return new InMemoryUserDetailsManager(publicUser);
//    }
//}
