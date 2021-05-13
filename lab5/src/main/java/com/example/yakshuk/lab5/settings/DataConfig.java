package com.example.yakshuk.lab5.settings;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class DataConfig {

    private static final String UNIT_NAME = "default";
    private EntityManager entityManager;

    @PostConstruct
    public void DataConfig() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        entityManager = factory.createEntityManager();
    }
    @PostConstruct
    public EntityManager getEntityManager(){
        return entityManager;
    }

}

