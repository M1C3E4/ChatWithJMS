package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.People;

import java.util.List;

public interface PeopleService {
    void addPeople(People people);
    void removePeopleByName(String name);
    void ifPeopleAlreadyExists(String peopleName);
    List<String> getPeopleDucts(String peopleName);
}
