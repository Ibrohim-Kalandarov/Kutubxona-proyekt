package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.filter.MyFilter;

import java.util.List;

public class CartService {


    public void add(User user, Book book) {

        user.getCart().getBook().add(book);
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user.getCart());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean isFound(List<Book> books, Book book1) {
        for (Book item : books) {
            if (item.equals(book1)) {
                return false;
            }
        }
        return true;
    }//topolmasa true qaytadi

    public List<Book> getBooks() {
        User user = MyFilter.getCurrentUser();
        return user.getCart().getBook();
    }

    private static CartService instance;

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }


}
