package com.epam.testtask.formatters;

import com.epam.testtask.model.User;
import com.epam.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class UserFormatter implements Formatter<User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User parse(String s, Locale locale) throws ParseException {
        return userService.findById(Integer.parseInt(s));
    }

    @Override
    public String print(User user, Locale locale) {
        return user.getName();
    }
}
