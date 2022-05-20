package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.People;

import java.util.List;

public interface DuctRepo {
    void addPeopleFromDuctIntoDuct(People people, Duct duct);
    void deleteDuctPeople(People people, Duct duct);
    List<People> getDuctPeople(Duct duct);
}
