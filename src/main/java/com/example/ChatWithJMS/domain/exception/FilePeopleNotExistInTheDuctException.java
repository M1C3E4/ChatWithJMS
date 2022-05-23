package com.example.ChatWithJMS.domain.exception;

public class FilePeopleNotExistInTheDuctException extends RuntimeException{
    public FilePeopleNotExistInTheDuctException(){
        super("plik lub użytkownik nie istnieje w tym kanale");
    }
}
