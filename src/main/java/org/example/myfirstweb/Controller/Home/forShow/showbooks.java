package org.example.myfirstweb.Controller.Home.forShow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.entity.Book;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-books")
public class showbooks extends HttpServlet {
    BookService service=BookService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> allBooks = service.getAllBooks();
        req.setAttribute("books", allBooks);

        req.getRequestDispatcher("templates/forHome/showbooks.jsp").forward(req, resp);
    }
}
