package com.example.ChatWithJMS.adapters.api.mappers;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.InformationDTO;
import com.example.ChatWithJMS.domain.Information;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {Instant.class, UUID.class})
public interface InformationMapper {
    @Mapping(target = "doTime", expression = "java(java.sql.Timestap.from(Instant.now()))")
    @Mapping(target = "informationId", expression = "java(java.util.UUID.randomUUID())")
    Information toDomain(InformationDTO informationDTO);
    InformationDTO toDto(Information information);
}
