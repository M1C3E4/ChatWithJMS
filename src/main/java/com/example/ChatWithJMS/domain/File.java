package com.example.ChatWithJMS.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Builder
public class File {
    private UUID fileId;
    private String peopleName;
    private String fileName;
    private String pathFile;
    private String ductName;
    @Setter
    private byte[] subject;
    private Timestamp doTime;
}
