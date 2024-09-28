package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Buy;
import org.example.myfirstweb.entity.User;

import java.util.List;

public class BuyService {





    public void add(Buy buy) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(buy);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<Buy> getUserBuy(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("select b from  Buy b where b.user=:user")
                .setParameter("user", user).getResultList();

    }

    public List<Buy> getlll() {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("select b from  Buy b")
                .getResultList();

    }


    private static BuyService instance;

    public static BuyService getInstance() {
        if (instance == null) {
            instance = new BuyService();
        }
        return instance;
    }

}
