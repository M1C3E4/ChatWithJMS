package com.example.ChatWithJMS.adapters.durable.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "information")
public class InformationEntity {
    @Id
    @Column(name = "information_id", nullable = false)
    private UUID informationId;
    @Column(name = "people_name", nullable = false)
    private String peopleName;
    @Column(name = "subject")
    private String subject;
    @Column(name = "doTime", nullable = false)
    private Timestamp doTime;
    @ElementCollection
    private List<String> accessPeopleList = new ArrayList<>();
}
