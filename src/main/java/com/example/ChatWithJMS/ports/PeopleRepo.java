package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.People;

import java.util.Optional;

public interface PeopleRepo {
    void addPeople(People people);
    void deletePeopleOfChatByName(String name);
    Optional<People> getChatPeopleByName(String name);
}
