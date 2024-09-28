package org.example.myfirstweb.Controller.Home.forAdd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.CartService;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;

@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
    BookService bookService = BookService.getInstance();
    CartService cartService = CartService.getInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("bookId"));
        Book book = bookService.getBook(id);


        User user = MyFilter.getCurrentUser();

        boolean found = cartService.isFound(user.getCart().getBook(), book);
        if (found) {

            cartService.add(user,book);
            req.setAttribute("success", "Kitob Savatga Qo'shildi!");
            req.setAttribute("url", "/home");
            req.getRequestDispatcher("/templates/SUCCESS.jsp").forward(req, resp);
        }else {
           req.setAttribute("warning","Bu Kitob Savatda Mavjud!");
           req.setAttribute("url","/home");
           req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
        }



    }

}
