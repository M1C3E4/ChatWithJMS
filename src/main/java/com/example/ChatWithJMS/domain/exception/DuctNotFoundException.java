package com.example.ChatWithJMS.domain.exception;

public class DuctNotFoundException extends RuntimeException{
    public DuctNotFoundException(){
        super("kanał nie istnieje");
    }
}
