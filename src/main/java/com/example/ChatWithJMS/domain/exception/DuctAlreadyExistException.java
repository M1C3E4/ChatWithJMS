package com.example.ChatWithJMS.domain.exception;

public class DuctAlreadyExistException extends RuntimeException{
    public DuctAlreadyExistException(){
        super("kanał już istnieje");
    }
}
