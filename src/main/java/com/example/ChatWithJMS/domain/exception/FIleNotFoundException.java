package com.example.ChatWithJMS.domain.exception;

public class FIleNotFoundException extends RuntimeException{
    public FIleNotFoundException(){
        super("plik nie istnieje");
    }
}
