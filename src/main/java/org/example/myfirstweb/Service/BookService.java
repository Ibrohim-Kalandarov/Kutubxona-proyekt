package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Book;

import java.util.List;
import java.util.Optional;


public class BookService {

    public void addBook(Book book) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void updateBook(Book book) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Book getBook(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.find(Book.class, id);

    }

    public Book getBookById(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Book> list = entityManager
                .createQuery("select b from Book b where b.id = :id")
                .setParameter("id", id)
                .getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return (Book) list.get(0);
    }

    public List<Book> getBookByTitle(String title) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Book> books = entityManager.createNamedQuery("byTitleBook", Book.class).setParameter("title", title).getResultList();
        if (books != null) {
            return books;
        }
        return null;

    }

    public void deleteBook(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }

    public List<Book> getAllBooks() {
        EntityManager entityManager = Datasource.getEntityManager();
        ;
        return entityManager.createQuery("select b from Book b").getResultList();

    }

    private static BookService instance;

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }


}
