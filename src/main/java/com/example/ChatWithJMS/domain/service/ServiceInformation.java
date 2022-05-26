package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.PeopleNotExistInDuctException;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.InformationRepo;
import com.example.ChatWithJMS.ports.InformationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
@NoArgsConstructor
public class ServiceInformation implements InformationService {

    private InformationRepo informationRepo;
    private DuctsRepo ductsRepo;

    @Override
    public void send(Information information, String ductName) {
        var duct = ductsRepo.getDuctByName(ductName).orElseThrow(DuctNotFoundException::new);
        var peopleName = duct.getDuctPeople()
                .stream()
                .map(People::getPeopleName)
                .toList();
        if(peopleName.contains(information.getPeopleName())){
            informationRepo.sendInformation(information, duct);
        }else throw new PeopleNotExistInDuctException();
    }
}
