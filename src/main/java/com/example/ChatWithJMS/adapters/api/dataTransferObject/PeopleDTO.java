package com.example.ChatWithJMS.adapters.api.dataTransferObject;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class PeopleDTO {
    private UUID peopleId;
    private String peopleName;
    private Timestamp doTime;

}
