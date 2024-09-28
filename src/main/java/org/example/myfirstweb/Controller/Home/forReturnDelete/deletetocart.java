package org.example.myfirstweb.Controller.Home.forReturnDelete;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.CartService;
import org.example.myfirstweb.db.Datasource;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;

@WebServlet("/deletetocart")

public class deletetocart extends HttpServlet {
    BookService bookService = BookService.getInstance();
    CartService cartService = CartService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("bookId"));
        Book book = bookService.getBook(id);

        User user = MyFilter.getCurrentUser();
        user.getCart().getBook().remove(book);
        EntityManager entityManager = Datasource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.merge(user.getCart());
        entityManager.getTransaction().commit();
        entityManager.close();
        req.setAttribute("success", "Kitob Savatdan O'chirildi!");
        req.setAttribute("url", "/home");
        req.getRequestDispatcher("/templates/SUCCESS.jsp").forward(req, resp);


    }
}
