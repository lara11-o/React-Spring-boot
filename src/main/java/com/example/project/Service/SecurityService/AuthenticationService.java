package com.example.project.Service.SecurityService;

import com.example.project.DTO.request.LoginRequest;
import com.example.project.DTO.request.SignupRequest;
import com.example.project.DTO.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignupRequest request);

    JwtAuthenticationResponse signin(LoginRequest request);
}
