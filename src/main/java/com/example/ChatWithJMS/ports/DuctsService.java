package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;

import java.util.List;

public interface DuctsService {
    void addDuct(Duct duct);
    void removeDuct(String ductName);
    List<Duct> getDuctList();
}
