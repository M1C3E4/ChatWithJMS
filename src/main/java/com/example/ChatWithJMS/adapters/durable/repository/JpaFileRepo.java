package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.entity.DuctEntity;
import com.example.ChatWithJMS.adapters.durable.entity.FileEntity;
import lombok.Setter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class JpaFileRepo {

    @Setter
    @PersistenceContext
    EntityManager entityManager;

    private static final String LOCATION_DATA = "F:\\file\\data\\";

    public void sendFile(FileEntity fileEntity, byte[] subject, DuctEntity ductEntity){
        var location = save(subject, fileEntity.getFileName() );
        fileEntity.setPathFile(location);
        entityManager.persist(fileEntity);
        ductEntity.getFileList().add(fileEntity);
        entityManager.merge(ductEntity);
    }

    private String save(byte[] subject, String nameFile){
        var location = LOCATION_DATA + nameFile;
        File file = new File(location);
        try(FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(file))){
            fileOutputStream.write(subject);
        }catch (IOException e){
            e.printStackTrace();
        }
        return location;
    }

    public Optional<FileEntity> getFileByName(String fileName){
        try {
            return Optional.of((FileEntity) entityManager.createQuery("select a From FileEntity a where a.fileName like :name")
                    .setParameter("name", fileName).getSingleResult());
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public byte[] contextFile(String location){
        byte[] subject = new byte[0];
        try(var input = new FileInputStream(location)){
            subject = input.readAllBytes();
        }catch (IOException e){
            e.printStackTrace();
        }
        return subject;
    }

}
