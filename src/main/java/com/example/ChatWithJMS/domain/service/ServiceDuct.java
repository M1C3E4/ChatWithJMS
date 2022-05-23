package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.DuctRepo;
import com.example.ChatWithJMS.ports.DuctService;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.PeopleRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
@NoArgsConstructor
public class ServiceDuct implements DuctService {

    private DuctRepo ductRepo;
    private DuctsRepo ductsRepo;
    private PeopleRepo peopleRepo;


    @Override
    public void addPeopleFromDuctIntoDuct(String peopleName, String ductName) {
        var people = peopleRepo.getChatPeopleByName(peopleName);
        var duct = ductsRepo.getDuctByName(ductName);
    }

    @Override
    public void deleteDuctPeople(String peopleName, String ductName) {
        var duct = ductsRepo.getDuctByName(ductName);
        var people = peopleRepo.getChatPeopleByName(peopleName);
    }

    @Override
    public List<Information> historyDownloading(String ductName, String peopleName) {
        return null;
    }
}
