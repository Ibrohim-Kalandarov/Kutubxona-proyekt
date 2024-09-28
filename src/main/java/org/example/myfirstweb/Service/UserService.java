package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Cart;
import org.example.myfirstweb.entity.User;

import java.util.List;
import java.util.Optional;


public class UserService {

    public void addCart(Cart cart) {
        EntityManager em = Datasource.getEntityManager();
        em.getTransaction().begin();
        em.persist(cart);
        em.getTransaction().commit();
        em.close();
    }


    public void add(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public User findById(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<User> list = entityManager
                .createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return (User) list.get(0);

    }

    public boolean check(String email) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<User> result = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.isEmpty(); // agar ro'yxat bo'sh bo'lsa true qaytaradi (email topilmadi)
    }

    public User findByEmail(String email) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class).setParameter("email", email).getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            User user = list.get(0);
            return user;
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers() {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createNamedQuery("allUser", User.class).getResultList();

    }

    public List<User> getActiveUsers() {
        EntityManager entityManager = Datasource.getEntityManager();
        return (List<User>) entityManager.createQuery("select u from User u where u.active = true", User.class).getResultList();
    }

    public List<User> getPassiveUsers() {
        EntityManager entityManager = Datasource.getEntityManager();
        return (List<User>) entityManager.createQuery("select u from User u where u.active = false", User.class).getResultList();
    }

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

}
