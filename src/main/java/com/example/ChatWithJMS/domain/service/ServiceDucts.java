package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
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
        ductsRepo.addDuct(duct);
    }

    @Override
    public void removeDuct(String duct) {
        ductsRepo.removeDuct(duct);
    }

    @Override
    public List<Duct> getDuctList() {
        return ductsRepo.getDuctList();
    }
}
