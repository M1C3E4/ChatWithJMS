package com.example.ChatWithJMS.domain.exception;

public class PeopleNotFoundException extends RuntimeException{
    public PeopleNotFoundException(){
        super("użytkownika nie znaleziono");
    }
}
