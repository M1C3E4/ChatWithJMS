package com.example.ChatWithJMS.domain.proxy;

import com.example.ChatWithJMS.adapters.javaMessageService.JavaMessageServiceWithActiveMQ;
import com.example.ChatWithJMS.domain.File;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.FileService;
import lombok.Setter;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
@Setter
public abstract class ProxyForFileService implements FileService {

    @Delegate
    @Inject
    private FileService fileService;
    @Inject
    private JavaMessageServiceWithActiveMQ javaMessageServiceWithActiveMQ;

    @Override
    public void save(File file){
        fileService.save(file);
        var information = Information.builder()
                .peopleName(file.getPeopleName())
                .doTime(file.getDoTime())
                .information("wysyłam plik " + ": " + file.getFileName())
                .ductName(file.getDuctName())
                .build();
        javaMessageServiceWithActiveMQ.activeMq(information);
    }

}
