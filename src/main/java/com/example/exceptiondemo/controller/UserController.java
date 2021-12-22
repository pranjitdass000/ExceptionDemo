package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.exception.UserAlreadyExistException;
import com.example.exceptiondemo.model.User;
import com.example.exceptiondemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlreadyExistException {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);

    }

}
