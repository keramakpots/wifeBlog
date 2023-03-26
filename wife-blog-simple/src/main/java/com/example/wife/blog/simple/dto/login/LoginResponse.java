package com.example.wife.blog.simple.dto.login;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;

    public LoginResponse(String token) {
        this.token = token;
    }
}