package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.entity.DuctEntity;
import com.example.ChatWithJMS.adapters.durable.entity.InformationEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaInformationRepo {

    @Setter
    @PersistenceContext
    EntityManager entityManager;

    public void sendInformation(InformationEntity informationEntity, DuctEntity ductEntity){
        entityManager.persist(informationEntity);
        ductEntity.getInformationList().add(informationEntity);
        entityManager.merge(ductEntity);
    }

}
