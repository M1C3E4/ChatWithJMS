package com.example.ChatWithJMS.adapters.durable.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.Timestamp;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "file")
public class FileEntity {
    @Id@Column(name = "file_id", nullable = false)
    private UUID fileId;
    @Column(name = "people_Name", nullable = false)
    private String peopleName;
    @Column(name = "finleName", nullable = false)
    private String fileName;
    @Column(name = "path_file", nullable = false)
    private String pathFile;
    @Column(name = "do_Time", nullable = false)
    private Timestamp doTime;
}
