package com.ubuntutech.legalservicies.model;

import com.ubuntutech.legalservicies.exceptions.UserNotFoundException;
import com.ubuntutech.legalservicies.model.data.UserRepository;
import com.ubuntutech.legalservicies.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplService implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(User newUser) {
        return this.userRepository.save(newUser);
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User newUser, Long id) {
        return this.userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    return this.userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return this.userRepository.save(newUser);
                });
    }
}
