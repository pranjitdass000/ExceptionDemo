package com.example.exceptiondemo.exception;

public class UserAlreadyExistException extends Exception{
    private String message;
    public UserAlreadyExistException(){

    }
    public UserAlreadyExistException(String message){
        super();
        this.message = message;
    }
}
