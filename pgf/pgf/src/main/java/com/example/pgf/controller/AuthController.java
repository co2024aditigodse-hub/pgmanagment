package com.example.pgf.controller;

import com.example.pgf.dto.LoginDto;
import com.example.pgf.dto.LoginResponse;
import com.example.pgf.dto.RegisterDto;
import com.example.pgf.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginDto request) {
        return authService.login(request);
    }
}