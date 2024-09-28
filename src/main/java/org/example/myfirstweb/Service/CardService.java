package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Card;
import org.example.myfirstweb.entity.User;

import java.util.List;

public class CardService {

    public void add(Card card) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(card);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Card card) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(card);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean find(User user){
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        List<Card> resultList = entityManager.createNamedQuery("findCard", Card.class).setParameter("user", user).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return !resultList.isEmpty();
    }
    public Card findCard(User user){
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        List<Card> resultList = entityManager.createNamedQuery("findCard", Card.class).setParameter("user", user).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (resultList.isEmpty()){
            return null;
        }else {
            return  resultList.get(0);
        }

    }


    private static CardService instance;

    public static CardService getInstance() {
        if (instance == null) {
            instance = new CardService();
        }
        return instance;
    }

}
