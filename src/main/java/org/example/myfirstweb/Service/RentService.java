package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.Rent;
import org.example.myfirstweb.entity.User;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RentService {


    public List<Rent> AllJarimali() {
        EntityManager em = Datasource.getEntityManager();
        return em.createNamedQuery("jarimali", Rent.class).getResultList();
    }


    public List<Rent> findAllJarima() {
        List<Rent> Rrents = new ArrayList<>();
        List<Rent> rents = Active();
        if (!rents.isEmpty()) {
            for (Rent r : rents) {
                if (r.getTo_date().isBefore(LocalDate.now())) {
                    LocalDate toDate = r.getTo_date();
                    LocalDate currentDate = LocalDate.now();
                    long DD = ChronoUnit.DAYS.between(toDate, currentDate);
                    double d = DD * 20000;
                    r.setJarima(d);
                    EntityManager em = Datasource.getEntityManager();
                    em.getTransaction().begin();
                    em.merge(r);
                    em.getTransaction().commit();
                    em.close();
                    Rrents.add(r);
                }
            }
        }
        return Rrents;
    }

    private List<Rent> Active() {
        EntityManager em = Datasource.getEntityManager();
        return em.createNamedQuery("getActiveRent", Rent.class).getResultList();
    }


    public boolean isBookRented(Book book) {
        EntityManager entityManager = Datasource.getEntityManager();
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(r) FROM Rent r WHERE r.book = :book", Long.class);
            query.setParameter("book", book);

            long count = query.getSingleResult();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    public List<Rent> getActiveiveRents() {
        EntityManager entityManager = Datasource.getEntityManager();
        return (List<Rent>) entityManager.createQuery("select r from Rent r where r.active = true", Rent.class).getResultList();
    }

    public List<Rent> getPassiveRents() {
        EntityManager entityManager = Datasource.getEntityManager();
        return (List<Rent>) entityManager.createQuery("select r from Rent r where r.active = false", Rent.class).getResultList();
    }

    public List<Rent> getActiveRents(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("SELECT r FROM Rent r WHERE r.user = :user AND r.active = true", Rent.class).setParameter("user", user).getResultList();
    }

    public List<Rent> getPassiveRents(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("SELECT r FROM Rent r WHERE r.user = :user AND r.active = false", Rent.class).setParameter("user", user).getResultList();
    }

    public long countUserActiveRents(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("SELECT COUNT(r) FROM Rent r WHERE r.user = :user AND r.active = true", Long.class).setParameter("user", user).getSingleResult();
    }


    public long countUserAllRents(User user) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createQuery("SELECT COUNT(r) FROM Rent r WHERE r.user = :user", Long.class).setParameter("user", user).getSingleResult();
    }


    public void Add(Rent rent) {
        EntityManager entityManager = Datasource.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(rent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateRent(Rent rent) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(rent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Rent getRent(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        return (Rent) entityManager.createNamedQuery("getRent").setParameter("id", id).getSingleResult();
    }

    public List<Rent> getRents() {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createNamedQuery("allRent", Rent.class).getResultList();
    }

    private static RentService instance;

    public static RentService getInstance() {
        if (instance == null) {
            instance = new RentService();
        }
        return instance;
    }

}
