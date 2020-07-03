package com.epam.testtask.service;

import com.epam.testtask.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    boolean deleteById(int id);

}
