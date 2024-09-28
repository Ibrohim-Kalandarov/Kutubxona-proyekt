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

@WebServlet("/search")
public class search extends HttpServlet {
    BookService bookService=BookService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("query");

        List<Book> book = bookService.getBookByTitle(title);
        if(book.isEmpty()){
            req.setAttribute("warning","Kitob topilmadi!");
            req.setAttribute("url","/home");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("books", book);
        req.getRequestDispatcher("templates/forHome/qidiruvdagibook.jsp").forward(req, resp);


    }
}
