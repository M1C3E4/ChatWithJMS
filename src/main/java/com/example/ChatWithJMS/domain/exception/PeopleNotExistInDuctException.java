package com.example.ChatWithJMS.domain.exception;

public class PeopleNotExistInDuctException extends RuntimeException{

    public PeopleNotExistInDuctException(){
        super("użytkownik nie istnieje w tym kanale");
    }
}
