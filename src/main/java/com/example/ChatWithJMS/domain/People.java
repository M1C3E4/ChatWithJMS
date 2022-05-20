package com.example.ChatWithJMS.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Builder
@EqualsAndHashCode
public class People {
    private UUID peopleId;
    private String peopleName;
    private Timestamp doTime;
}
