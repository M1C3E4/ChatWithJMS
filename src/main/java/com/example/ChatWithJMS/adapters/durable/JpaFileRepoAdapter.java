package com.example.ChatWithJMS.adapters.durable;

import com.example.ChatWithJMS.adapters.durable.mappers.JpaDurableFileMapper;
import com.example.ChatWithJMS.adapters.durable.mappers.JpeDurableDuctMapper;
import com.example.ChatWithJMS.adapters.durable.repository.JpaFileRepo;
import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.File;
import com.example.ChatWithJMS.ports.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor(onConstructor_ =@Inject)
public class JpaFileRepoAdapter implements FileRepository {

    private final JpeDurableDuctMapper jpeDurableDuctMapper;
    private final JpaDurableFileMapper jpaDurableFileMapper;
    private final JpaFileRepo jpaFileRepo;

    @Override
    public Optional<File> getFileByName(String name) {
        var fileEntity = jpaFileRepo.getFileByName(name);
        return fileEntity.map(jpaDurableFileMapper::toDomain);
    }

    @Override
    public void sendFile(File file, Duct duct) {
        var fileEntity = jpaDurableFileMapper.toEntity(file);
        var ductEntity = jpeDurableDuctMapper.toEntity(duct);
        jpaFileRepo.sendFile(fileEntity, file.getSubject(), ductEntity);
    }

    @Override
    public byte[] subject(String subjectLocation) {
        return jpaFileRepo.contextFile(subjectLocation);
    }
}
