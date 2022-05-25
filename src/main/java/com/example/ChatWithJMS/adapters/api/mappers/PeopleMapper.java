package com.example.ChatWithJMS.adapters.api.mappers;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.PeopleDTO;
import com.example.ChatWithJMS.domain.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {Instant.class, UUID.class})
public interface PeopleMapper {
    @Mapping(target = "doTime", expression = "java(java.sql.TimeStamp.from(Instant.now()))")
    @Mapping(target = "peopleId", expression = "java(java.util.UUID.randomUUID())")
    People toDomain(PeopleDTO peopleDTO);
}
