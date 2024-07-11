package com.example.repository;

import com.example.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, Long> {
    UserBean findByName(String name);
}

