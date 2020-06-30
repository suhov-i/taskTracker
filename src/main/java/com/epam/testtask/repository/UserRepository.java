package com.epam.testtask.repository;

import com.epam.testtask.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User get(int id);

    boolean delete(int id);

    List<User> getAll();
}
