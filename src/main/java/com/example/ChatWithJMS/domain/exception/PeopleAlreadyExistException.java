package com.example.ChatWithJMS.domain.exception;

public class PeopleAlreadyExistException extends RuntimeException{
    public PeopleAlreadyExistException(){
        super("użytkownik już istnieje");
    }
}
