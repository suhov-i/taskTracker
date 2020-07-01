package com.epam.testtask.controller;

import com.epam.testtask.model.User;
import com.epam.testtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        List<User> users = repository.getAll();
        model.addAttribute("users", users);
        session.setAttribute("allUsers", users);
        return "users/users-list";
    }

    @GetMapping("/addUserForm")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("user") User user) {
        //forcing to save new (not update)
        user.setId(0);
        repository.save(user);

        //post-redirect-get
        return "redirect:/users/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int userId) {
        repository.delete(userId);
        return "redirect:/users/list";
    }
}
