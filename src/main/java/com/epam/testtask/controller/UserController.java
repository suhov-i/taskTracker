package com.epam.testtask.controller;

import com.epam.testtask.model.User;
import com.epam.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //trims string from form
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        List<User> users = service.findAll();
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
    public String save(@Valid @ModelAttribute ("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add-form";
        }

        //forcing to save new (not update)
        user.setId(0);
        service.save(user);

        //post-redirect-get
        return "redirect:/users/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int userId) {
        //success param is for js popup with alert if not deleted
        if (!service.deleteById(userId)) {
            return "redirect:/users/list?success=false";
        } else {
            return "redirect:/users/list?success=true";
        }
    }
}
