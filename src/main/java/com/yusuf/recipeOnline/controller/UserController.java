package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public String loginRegister() {
        return "login-register";
    }


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User correctUser = userService.getByEmail(user.getEmail());
        if (Objects.equals(user.getPassword(), correctUser.getPassword())) {
            return "redirect:/homepage";
        } else {
            return "login-register";
        }
    }

}

