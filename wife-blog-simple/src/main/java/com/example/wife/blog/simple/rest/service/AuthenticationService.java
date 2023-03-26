package com.example.wife.blog.simple.rest.service;

import com.example.wife.blog.simple.entity.BlogUser;
import com.example.wife.blog.simple.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private BlogUserRepository userRepository;

    public boolean authenticate(String username, String password) {
        Optional<BlogUser> userOptional = Optional.ofNullable(userRepository.findByUserName(username));
        if (userOptional.isPresent()) {
            BlogUser user = userOptional.get();
            return BCrypt.checkpw(password, user.getPassword());
        } else {
            return false;
        }
    }

    public String generateToken(String username) {
        // generate JWT token
        return "JWT_TOKEN";
    }
}
