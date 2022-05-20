package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;

import java.util.List;
import java.util.Optional;

public interface DuctsRepo {
    void addDuct(Duct duct);
    void removeDuct(String duct);
    List<Duct> getDuctList();
    Optional<Duct> getDuctByName(String ductName);

}
