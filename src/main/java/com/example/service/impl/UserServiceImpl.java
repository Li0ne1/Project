package com.example.service.impl;

import com.example.entity.UserBean;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserBean loginIn(String name, String password) {
        UserBean user = userRepository.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void insert(String name, String password) {
        if (userRepository.findByName(name) != null) {
            throw new IllegalArgumentException("Username already exists. Please choose another.");
        }
        UserBean user = new UserBean();
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
    }
}

