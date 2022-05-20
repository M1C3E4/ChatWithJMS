package com.example.ChatWithJMS.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Information implements Serializable {

    @Setter
    private UUID msgId;
    private String peopleName;
    private String information;
    @Setter
    private String ductName;
    private Timestamp doTime;
    private List<String> accessPeopleList;

    public String msgToJson() {
        return
                "{\"peopleName\" : \"" + peopleName + "\",\"doTime\" : \"" + doTime.toString() + "\",\"ductName\" : \""
                        + ductName + "\"," + "\"information\" : \"" + information + "\"}";
    }

}
