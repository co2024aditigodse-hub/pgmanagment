package com.example.pgf.service;

import com.example.pgf.entity.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    void deleteRole(Long id);

}