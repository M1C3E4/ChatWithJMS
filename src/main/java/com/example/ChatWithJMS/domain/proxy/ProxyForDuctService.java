package com.example.ChatWithJMS.domain.proxy;

import com.example.ChatWithJMS.adapters.javaMessageService.JavaMessageServiceWithActiveMQ;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.DuctService;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;

@Decorator
@Setter
public abstract class ProxyForDuctService implements DuctService {

    @Inject
    @Delegate
    private DuctService ductService;
    @Inject
    private JavaMessageServiceWithActiveMQ javaMessageServiceWithActiveMQ;

    @Override
    public void deleteDuctPeople(String peopleName, String ductName){
        ductService.deleteDuctPeople(peopleName, ductName);
        javaMessageServiceWithActiveMQ.activeMq(Information.builder()
                .information(peopleName + "wyszedł z kanału")
                .ductName(ductName)
                .peopleName(peopleName)
                .doTime(Timestamp.from(Instant.now()))
                .build());
    }

    @Override
    public void addPeopleFromDuctIntoDuct(String peopleName, String ductName){
        ductService.addPeopleFromDuctIntoDuct(peopleName, ductName);
        javaMessageServiceWithActiveMQ.activeMq(Information.builder()
                .information("dołączono do kanału")
                .ductName(ductName)
                .peopleName(peopleName)
                .doTime(Timestamp.from(Instant.now()))
                .build());
    }

}
