package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.File;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.FileRepository;
import com.example.ChatWithJMS.ports.FileService;
import lombok.RequiredArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ServiceFile implements FileService {

    private final FileRepository fileRepository;
    private final DuctsRepo ductsRepo;


    @Override
    public void save(File file) {
        var duct = ductsRepo.getDuctByName(file.getDuctName());
        fileRepository.sendFile(file, duct);
    }

    @Override
    public File getFileByName(String fileName, String peopleName, String ductName) {
        var duct = ductsRepo.getDuctByName(ductName);
        var file = fileRepository.getFileByName(fileName);
        return null;
    }
}
