package com.epam.testtask.controller;

import com.epam.testtask.model.Task;
import com.epam.testtask.model.User;
import com.epam.testtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{userId}")
    public User get(@PathVariable int userId) {
        //TODO: null check
        return repository.get(userId);
    }

    @GetMapping("/")
    public List<User> getAll() {
        return repository.getAll();
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        //forcing to save new (not update)
        user.setId(0);
        return repository.save(user);
    }

    @PutMapping("/")
    public User update(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/{userId}")
    public boolean delete(@PathVariable int userId) {
        //TODO: false - null
        return repository.delete(userId);
    }
}
