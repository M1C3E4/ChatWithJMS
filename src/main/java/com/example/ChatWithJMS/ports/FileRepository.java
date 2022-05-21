package com.example.ChatWithJMS.ports;

import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.File;
import java.util.Optional;

public interface FileRepository {
    Optional<File> getFileByName(String name);
    void sendFile(File file, Duct duct);
    byte[] subject(String subjectLocation);
}
