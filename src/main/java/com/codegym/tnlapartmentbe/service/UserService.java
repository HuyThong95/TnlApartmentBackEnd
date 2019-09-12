package com.codegym.tnlapartmentbe.service;

import com.codegym.tnlapartmentbe.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    void saveUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> findUserById(Long id);
}
