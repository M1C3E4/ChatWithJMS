package com.example.ChatWithJMS.adapters.api.mappers;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.DuctDTO;
import com.example.ChatWithJMS.domain.Duct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.UUID;

@Mapper(componentModel = "cdi", imports = {UUID.class})
public interface DuctMapper {
    DuctDTO toDto(Duct duct);
    @Mapping(target = "ductId", expression = "java(java.util.UUID.randomUUID())")
    Duct toDomain(DuctDTO ductDTO);
}
