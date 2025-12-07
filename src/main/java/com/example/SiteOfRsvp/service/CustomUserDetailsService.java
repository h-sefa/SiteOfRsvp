package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.entity.User;
import com.example.SiteOfRsvp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {


        private final UserRepository userRepository;

        public CustomUserDetailsService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> {
                        System.out.println("❌ User not found: " + email);
                        return new UsernameNotFoundException("User not found with email: " + email);
                    });

            return user;
        }

}
