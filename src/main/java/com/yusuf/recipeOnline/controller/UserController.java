package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.dto.UserDto;
import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestBody UserDto user) {
        User correctUser = userService.getByEmail(user.getEmail());
        if (Objects.equals(user.getPassword(), correctUser.getPassword())) {
            return new ResponseEntity<String>("http://localhost:8080/homepage", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("http://localhost:8080/user", HttpStatus.BAD_REQUEST);
        }
    }

}

