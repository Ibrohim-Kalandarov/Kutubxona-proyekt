package org.example.myfirstweb.Controller.Home.forShow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.CartService;
import org.example.myfirstweb.entity.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-cart")
public class showcart extends HttpServlet {
    CartService cartService = CartService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = cartService.getBooks();
        if (books.isEmpty()) {
            req.setAttribute("warning", "cart is empty");
            req.setAttribute("url", "/home");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);

        }


        req.setAttribute("books", books);
        req.getRequestDispatcher("templates/forHome/savat.jsp").forward(req, resp);

    }
}
