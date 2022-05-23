package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.domain.People;

import java.util.List;

public interface DuctService {
    void addPeopleFromDuctIntoDuct(String peopleName, String ductName);
    void deleteDuctPeople(String peopleName, String ductName);
    List<Information> historyDownloading(String ductName, String peopleName);
}
