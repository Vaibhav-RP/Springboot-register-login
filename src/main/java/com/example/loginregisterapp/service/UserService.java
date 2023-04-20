package com.example.loginregisterapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginregisterapp.entity.User;
import com.example.loginregisterapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> findUser(String name) {
        return userRepository.findByUsername(name);
    }

}

