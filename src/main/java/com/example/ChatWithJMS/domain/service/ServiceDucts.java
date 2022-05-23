package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.exception.DuctAlreadyExistException;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.DuctsService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ServiceDucts implements DuctsService {

    private final DuctsRepo ductsRepo;

    @Override
    public void addDuct(Duct duct) {
        if(!ductAlreadyExist(duct.getDuctName())) {
            ductsRepo.addDuct(duct);
        }else {
            throw new DuctAlreadyExistException();
        }
    }

    @Override
    public void removeDuct(String duct) {
        ductsRepo.removeDuct(duct);
    }

    @Override
    public List<Duct> getDuctList() {
        return ductsRepo.getDuctList();
    }

    private boolean ductAlreadyExist(String ductName){
        List<Duct> ducts = ductsRepo.getDuctList();
        return ducts.stream().map(Duct::getDuctName).anyMatch(c -> c.equals(ductName));
    }

}
