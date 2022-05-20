package com.example.ChatWithJMS.adapters.durable.mappers;

import com.example.ChatWithJMS.adapters.durable.entity.InformationEntity;
import com.example.ChatWithJMS.domain.Information;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "cdi", imports = UUID.class)
public interface JpaDurableInformationMapper {
    Information toDomain(InformationEntity informationEntity);
    InformationEntity toEntity(Information information);
}
