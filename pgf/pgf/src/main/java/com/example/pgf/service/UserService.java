package com.example.pgf.service;

import com.example.pgf.dto.RegisterDto;
import com.example.pgf.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto register(RegisterDto request);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

}