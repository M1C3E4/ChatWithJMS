package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.domain.People;

import java.util.List;

public interface DuctService {
    void addPeopleFromDuctIntoDuct();
    void deleteDuctPeople();
    List<Information> getHistory();
}
