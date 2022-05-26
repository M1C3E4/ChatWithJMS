package com.example.ChatWithJMS.domain.service;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.File;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.FIleNotFoundException;
import com.example.ChatWithJMS.domain.exception.FilePeopleNotExistInTheDuctException;
import com.example.ChatWithJMS.domain.exception.PeopleNotExistInDuctException;
import com.example.ChatWithJMS.ports.DuctsRepo;
import com.example.ChatWithJMS.ports.FileRepository;
import com.example.ChatWithJMS.ports.FileService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ServiceFile implements FileService {

    private final FileRepository fileRepository;
    private final DuctsRepo ductsRepo;


    @Override
    public void save(File file) {
        var duct = ductsRepo.getDuctByName(file.getDuctName()).orElseThrow(DuctNotFoundException::new);
        if(ifPeopleExistOnTheDuct(duct, file.getPeopleName())) {
            fileRepository.sendFile(file, duct);
        }else {
            throw new PeopleNotExistInDuctException();
        }
    }

    @Override
    public File getFileByName(String fileName, String peopleName, String ductName) {
        var duct = ductsRepo.getDuctByName(ductName).orElseThrow(DuctNotFoundException::new);
        var file = fileRepository.getFileByName(fileName).orElseThrow(FIleNotFoundException::new);
        if(ifPeopleExistOnTheDuct(duct, peopleName) && ifFileExistOnTheDuct(duct, fileName)){
            file.setSubject(fileRepository.subject(file.getPathFile()));
            return file;
        }else throw new FilePeopleNotExistInTheDuctException();
    }

    private boolean ifFileExistOnTheDuct(Duct duct, String fileName){
        var fileNamee = duct.getFileList().stream().map(File::getFileName).toList();
        return fileNamee.contains(fileName);
    }

    private boolean ifPeopleExistOnTheDuct(Duct duct, String peopleName){
        var peopleNamee = duct.getDuctPeople().stream().map(People::getPeopleName).toList();
        return peopleNamee.contains(peopleName);
    }

}
