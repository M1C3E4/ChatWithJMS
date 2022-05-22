package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.File;

public interface FileService {
    void save(File file);
    File getFileByName(String fileName, String peopleName, String ductName);
}
