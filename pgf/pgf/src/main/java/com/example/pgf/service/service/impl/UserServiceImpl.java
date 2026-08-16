package com.example.pgf.service.service.impl;

import com.example.pgf.dto.RegisterDto;
import com.example.pgf.dto.UserDto;
import com.example.pgf.entity.Role;
import com.example.pgf.entity.User;
import com.example.pgf.repository.RoleRepository;
import com.example.pgf.repository.UserRepository;
import com.example.pgf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(RegisterDto request) {

        // Role ID check
        if (request.getRoleId() == null) {
            throw new RuntimeException("Role ID is required");
        }

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Role Not Found with ID: " + request.getRoleId()
                        )
                );

        // Create User
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        // Password encrypt
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setAddress(request.getAddress());

        // Set Role
        user.setRole(role);

        // Save
        User savedUser = userRepository.save(user);

        return convertToDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found")
                );

        return convertToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();

        for (User user : users) {
            dtoList.add(convertToDto(user));
        }

        return dtoList;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found")
                );

        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setMobile(userDto.getMobile());
        user.setAddress(userDto.getAddress());

        User updated = userRepository.save(user);

        return convertToDto(updated);
    }

    @Override
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User Not Found");
        }

        userRepository.deleteById(id);
    }

    private UserDto convertToDto(User user) {

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        dto.setAddress(user.getAddress());

        if (user.getRole() != null) {
            dto.setRoleName(user.getRole().getRoleName());
        }

        return dto;
    }
}