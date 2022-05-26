package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.entity.PeopleEntity;
import lombok.Setter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class JpaPeopleRepo {
    @Setter
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private JpaDuctRepo jpaDuctRepo;

    public void save(PeopleEntity peopleEntity){
        entityManager.persist(peopleEntity);
    }
    public void remove(String peopleName){
        var peopleEntity = getByName(peopleName);
        peopleEntity.ifPresent(entities ->{
            entities.getDuctEntityList()
                    .forEach(d -> jpaDuctRepo.deleteDuctPeople(entities, d));
            entityManager.remove(entities);
        });
    }

    public Optional<PeopleEntity> getByName(String name) {
        try{
            return  Optional.of((PeopleEntity) entityManager.createQuery("select a From PeopleEntity a where a.peopleName like :name" )
                    .setParameter("name", name).getSingleResult());
        }catch (Exception e){
            return  Optional.empty();
        }
    }


}
