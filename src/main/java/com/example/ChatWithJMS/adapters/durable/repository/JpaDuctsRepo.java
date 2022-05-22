package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.entity.DuctEntity;
import lombok.Setter;
import lombok.var;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaDuctsRepo {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public void addDuct(DuctEntity ductEntity) {
        entityManager.persist(ductEntity);
    }

    public void removeDuct(String ductName) {
        var duct = getByName(ductName).get();
        entityManager.remove(duct);
    }

    public List<DuctEntity> getDucts() {
        TypedQuery<DuctEntity> query = entityManager.createQuery("select c from DuctEntity c", DuctEntity.class);
        return query.getResultList();
    }

    public Optional<DuctEntity> getByName(String name) {
        try {
            return Optional.of((DuctEntity) entityManager.createQuery("select a From DuctEntity a where a.ductName like :name")
                    .setParameter("name", name).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
