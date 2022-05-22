package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.entity.DuctEntity;
import com.example.ChatWithJMS.adapters.durable.entity.PeopleEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaDuctRepo{

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void addDuctPeople(PeopleEntity peopleEntity, DuctEntity ductEntity){
        ductEntity.getDuctPeoples().add(peopleEntity);
        entityManager.merge(ductEntity);
    }

    public List<PeopleEntity> getDuctPeople(DuctEntity ductEntity){
        return ductEntity.getDuctPeoples();
    }

    public void deleteDuctPeople(PeopleEntity peopleEntity, DuctEntity ductEntity){
        ductEntity.getDuctPeoples().remove(peopleEntity);
        entityManager.merge(ductEntity);
    }

}
