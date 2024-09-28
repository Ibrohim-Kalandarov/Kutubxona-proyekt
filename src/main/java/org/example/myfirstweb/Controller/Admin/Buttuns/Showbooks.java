package org.example.myfirstweb.Controller.Admin.Buttuns;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.entity.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/showbooks")
public class Showbooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = BookService.getInstance();
        List<Book> books = bookService.getAllBooks();
        req.setAttribute("books", books);
            RequestDispatcher dispatcher = req.getRequestDispatcher("templates/forAdmin/showbooks.jsp");
            dispatcher.forward(req, resp);

    }
}
