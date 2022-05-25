package com.example.ChatWithJMS.adapters.api.dataTransferObject;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class FileDTO {
    private UUID fileId;
    private String peoplName;
    private String file;
    private String subject;
    private String ductName;
    private Timestamp doTime;
}
