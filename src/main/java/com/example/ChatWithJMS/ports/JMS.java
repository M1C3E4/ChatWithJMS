package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Information;

public interface JMS {
    void activeMq(Information information);
}
