package com.epam.testtask.service;

import com.epam.testtask.model.User;
import com.epam.testtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public User get(int id) {
        return repository.get(id);
    }
}
