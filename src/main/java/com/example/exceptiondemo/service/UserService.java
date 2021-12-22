package com.example.exceptiondemo.service;

import com.example.exceptiondemo.exception.UserAlreadyExistException;
import com.example.exceptiondemo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistException;
    List<User> getAllUsers();
    User getUserById(int id);
}
