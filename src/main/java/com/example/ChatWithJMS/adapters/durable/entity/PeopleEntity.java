package com.example.ChatWithJMS.adapters.durable.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "people")
public class PeopleEntity {

    @Id
    @Column(name = "people_id", nullable = false)
    private UUID peopleId;
    @Column(name = "people_name", nullable = false, unique = true)
    private String peopleName;
    @Column(nullable = false)
    private Timestamp doTime;
    @ManyToMany(mappedBy = "ductPeoples")
    //private List<> ductEntityList;

}
