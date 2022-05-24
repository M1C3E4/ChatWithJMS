package com.example.ChatWithJMS.domain.proxy;

import com.example.ChatWithJMS.adapters.javaMessageService.JavaMessageServiceWithActiveMQ;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.InformationService;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Setter
@Decorator
public abstract class ProxyForInformationService implements InformationService {

    @Inject
    @Delegate
    private InformationService informationService;
    @Inject
    private JavaMessageServiceWithActiveMQ javaMessageServiceWithActiveMQ;

    @Override
    public void send(Information information, String ductName){
        informationService.send(information, ductName);
        information.setDuctName(ductName);
        javaMessageServiceWithActiveMQ.activeMq(information);
    }

}
