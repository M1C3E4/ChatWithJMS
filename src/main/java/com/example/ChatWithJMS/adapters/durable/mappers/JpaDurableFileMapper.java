package com.example.ChatWithJMS.adapters.durable.mappers;

import com.example.ChatWithJMS.adapters.durable.entity.FileEntity;
import com.example.ChatWithJMS.domain.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JpaDurableFileMapper {
    File toDomain(FileEntity fileEntity);
    FileEntity toEntity(File file);
}
