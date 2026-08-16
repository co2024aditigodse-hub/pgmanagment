package com.example.pgf.service;

import com.example.pgf.dto.LoginDto;
import com.example.pgf.dto.LoginResponse;
import com.example.pgf.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto request);

    LoginResponse login(LoginDto request);

}