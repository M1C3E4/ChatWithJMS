package com.example.ChatWithJMS.adapters.durable.mappers;

import com.example.ChatWithJMS.adapters.durable.entity.PeopleEntity;
import com.example.ChatWithJMS.domain.People;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JpaDurablePeopleMapper {
    People toDomain(PeopleEntity peopleEntity);
    PeopleEntity toEntity(People people);
}
