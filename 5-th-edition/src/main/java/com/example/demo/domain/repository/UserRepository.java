package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;


public interface UserRepository  {
    Iterable<User> findAll();

    User findOne (String name);

    void save(User user);
}
