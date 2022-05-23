package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.domain.exception.DuctAlreadyExistException;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.PeopleNotExistInDuctException;
import com.example.ChatWithJMS.domain.exception.PeopleNotFoundException;
import com.example.ChatWithJMS.ports.DuctRepo;
import com.example.ChatWithJMS.ports.DuctService;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.PeopleRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Slf4j
@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
@NoArgsConstructor
public class ServiceDuct implements DuctService {

    private DuctRepo ductRepo;
    private DuctsRepo ductsRepo;
    private PeopleRepo peopleRepo;

    @Override
    public void addPeopleFromDuctIntoDuct(String peopleName, String ductName) {
        var people = peopleRepo.getChatPeopleByName(peopleName).orElseThrow(DuctAlreadyExistException::new);
        var duct = ductsRepo.getDuctByName(ductName).orElseThrow(DuctNotFoundException::new);
        if(ifPeopleExistInDuct(duct, people)) throw new PeopleNotExistInDuctException();
        ductRepo.addPeopleFromDuctIntoDuct(people, duct);

    }

    @Override
    public void deleteDuctPeople(String peopleName, String ductName) {
        var duct = ductsRepo.getDuctByName(ductName).orElseThrow(DuctNotFoundException::new);
        var people = peopleRepo.getChatPeopleByName(peopleName).orElseThrow(PeopleNotFoundException::new);
        if (!ifPeopleExistInDuct(duct, people)) throw new PeopleNotExistInDuctException();
        ductRepo.deleteDuctPeople(people, duct);
    }

    @Override
    public List<Information> historyDownloading(String ductName, String peopleName) {
        var duct = ductsRepo.getDuctByName(ductName).orElseThrow(DuctNotFoundException::new);
        var people = peopleRepo.getChatPeopleByName(peopleName).orElseThrow(PeopleNotFoundException::new);

        if(!ifPeopleExistInDuct(duct, people)) throw new PeopleNotExistInDuctException();
        var informationList = duct.getMsgList()
                .stream()
                .filter( information -> information.getAccessPeopleList().contains(peopleName))
                .toList();
        informationList.forEach(information -> information.setDuctName(ductName));
        return informationList;
    }

    private boolean ifPeopleExistInDuct(Duct duct, People people){
        return duct.getDuctPeople()
                .stream()
                .anyMatch(m -> m.getPeopleName().equals(people.getPeopleName()));
    }

}
