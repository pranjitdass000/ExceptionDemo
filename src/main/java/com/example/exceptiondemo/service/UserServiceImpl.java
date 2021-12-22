package com.example.exceptiondemo.service;

import com.example.exceptiondemo.exception.UserAlreadyExistException;
import com.example.exceptiondemo.model.User;
import com.example.exceptiondemo.reposotory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getId())){
            throw new UserAlreadyExistException();
        }
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepository.findAll();
    }
    @Override
    public User getUserById(int id){
        return null;
    }
}
