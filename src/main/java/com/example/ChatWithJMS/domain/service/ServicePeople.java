package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.PeopleRepo;
import com.example.ChatWithJMS.ports.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor_ =@Inject)
public class ServicePeople implements PeopleService {

    private final PeopleRepo peopleRepo;
    private final DuctsRepo ductsRepo;

    @Override
    public void addPeople(People people) {
        peopleRepo.addPeople(people);
    }

    @Override
    public void removePeopleByName(String name) {
        peopleRepo.deletePeopleOfChatByName(name);
    }

    @Override
    public void ifPeopleAlreadyExists(String peopleName) {
        peopleRepo.getChatPeopleByName(peopleName);
    }

    @Override
    public List<String> getPeopleDucts(String peopleName) {
        var people = peopleRepo.getChatPeopleByName(peopleName);
        return ductsRepo.getDuctList().stream().filter(c -> c.getDuctPeople().contains(people))
                .map(Duct::getDuctName)
                .toList();
    }
}