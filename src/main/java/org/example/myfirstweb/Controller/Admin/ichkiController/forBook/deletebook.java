package org.example.myfirstweb.Controller.Admin.ichkiController.forBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.entity.Book;

import java.io.IOException;

@WebServlet("/deletebook")
public class deletebook extends HttpServlet {
    BookService bookService = BookService.getInstance();
    RentService rentService= RentService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Book book = bookService.getBookById(id);
        if (book != null) {
            boolean bookRented = rentService.isBookRented(book);
            if (!bookRented) {
                bookService.deleteBook(book.getId());
                resp.sendRedirect("/showbooks");
            }else {
                req.setAttribute("warning", "book rentga bog'langan o'chirib bo'lmaydi");
                req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            }


        }

    }
}
