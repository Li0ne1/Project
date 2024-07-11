package com.example.service;

import com.example.entity.UserBean;

public interface UserService {
    UserBean loginIn(String name, String password);
    void insert(String name, String password);
}

