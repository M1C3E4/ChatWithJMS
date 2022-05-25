package com.example.ChatWithJMS.adapters.api.mappers;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.FileDTO;
import com.example.ChatWithJMS.domain.File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {UUID.class, Instant.class})
public interface FileMapper {

    @Mapping(target = "doTime", expression = "java(java.sql.Timestamp.from(Instant.now()))")
    @Mapping(target = "fileId", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(source = "subject", target = "subject", qualifiedByName = "subjectToBytes")
    File toDomain(FileDTO fileDTO);
    @Mapping(source ="subject", target = "subject", qualifiedByName = "subjectToString")
    FileDTO toDto(File file);

    @Named("subjectToBytes")
    static byte[] stringToBytes(String subject){return Base64.getDecoder().decode(subject);}
    @Named("subjectToString")
    static String byteToString(byte[] subject){return Base64.getEncoder().encodeToString(subject);}
}
