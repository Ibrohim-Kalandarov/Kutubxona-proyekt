package org.example.myfirstweb.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Datasource {
    public static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static EntityManagerFactory datasource;
    static {
        datasource = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManager getEntityManager() {
        return datasource.createEntityManager();
    }
}
