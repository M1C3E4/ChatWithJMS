package com.example.ChatWithJMS.adapters.durable.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "duct")
public class DuctEntity {

    @Id
    @Column(name = "duct_id", nullable = false)
    private UUID ductId;
    @Column(name = "duct_name")
    private String ductName;
    @ManyToMany
    @JoinTable(name = "duct_People",
    joinColumns = @JoinColumn(name = "duct_id"),
    inverseJoinColumns = @JoinColumn(name = "people_id")
    )
    private List<PeopleEntity> ductPeoples = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "duct_information",
    joinColumns = @JoinColumn(name = "duct_id"),
    inverseJoinColumns = @JoinColumn(name = "information_id")
    )
    private List<InformationEntity> informationList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ductFile",
    joinColumns = @JoinColumn(name = "duct_id"),
    inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<FileEntity>fileList = new ArrayList<>();


}
