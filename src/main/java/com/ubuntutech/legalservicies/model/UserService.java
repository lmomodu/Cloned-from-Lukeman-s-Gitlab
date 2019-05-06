package com.ubuntutech.legalservicies.model;

import com.ubuntutech.legalservicies.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User save(User newUser);

    void deleteById(Long id);

    User updateUser(User newUser, Long id);

    User getUserById(Long id);
}
