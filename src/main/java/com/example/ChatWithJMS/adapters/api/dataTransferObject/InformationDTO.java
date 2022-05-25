package com.example.ChatWithJMS.adapters.api.dataTransferObject;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InformationDTO {
    private String peopleName;
    private String subject;
    private String ductName;
    private Timestamp doTime;
}
