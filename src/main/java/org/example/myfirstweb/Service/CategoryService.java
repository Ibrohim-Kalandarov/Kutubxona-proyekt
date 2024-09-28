package org.example.myfirstweb.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.Category;
import org.example.myfirstweb.enums.CategoryName;

import java.util.List;

public class CategoryService {


    public List<Category> getAllCategory() {
        EntityManager entityManager = Datasource.getEntityManager();
        return (List<Category>) entityManager.createNamedQuery("getAllCategory").getResultList();
    }

    public Category getCategory(Integer id) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.createNamedQuery("getCategorybyId", Category.class).setParameter("id", id).getSingleResult();

    }

    public List<Book> getAllCategoryBooks(CategoryName Catname) {
        EntityManager entityManager = Datasource.getEntityManager();
        Query query = entityManager.createQuery("select b from Book b where b.category.name = :name", Book.class).setParameter("name", Catname);
        return (List<Book>) query.getResultList();
    }


    public boolean isCategoryExists(int categoryId) {
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return category != null; // Agar category null bo'lmasa, true qaytaradi
    }



    private static CategoryService instance;

    public static CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
        }
        return instance;
    }


}
