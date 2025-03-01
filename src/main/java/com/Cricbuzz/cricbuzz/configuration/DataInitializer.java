package com.Cricbuzz.cricbuzz.configuration;

import com.Cricbuzz.cricbuzz.model.User;
import com.Cricbuzz.cricbuzz.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.findByUsername("Sid").isPresent()) {
                User user = new User("Sid", passwordEncoder.encode("Admin@123"), "PUBLIC");
                userRepository.save(user);
            }
        };
    }
}