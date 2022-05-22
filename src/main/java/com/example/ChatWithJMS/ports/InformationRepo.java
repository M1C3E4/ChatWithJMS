package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.Information;

public interface InformationRepo {
    void sendInformation(Information information, Duct duct);
}
