package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Information;

public interface InformationService {
    void send(Information information, String ductName);
}
