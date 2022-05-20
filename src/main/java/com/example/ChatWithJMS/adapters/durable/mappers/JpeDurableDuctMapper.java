package com.example.ChatWithJMS.adapters.durable.mappers;

import com.example.ChatWithJMS.adapters.durable.entity.DuctEntity;
import com.example.ChatWithJMS.domain.Duct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JpeDurableDuctMapper {
    Duct toDomain(DuctEntity ductEntity);
    DuctEntity toEntity(Duct duct);
}
