package com.example.demo.service;

import com.example.demo.model.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(long id);

    Role findByName(String name);

}
