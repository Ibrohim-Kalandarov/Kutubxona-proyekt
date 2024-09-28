package org.example.myfirstweb.Controller.Home.forAdd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.Rent;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/add-rent")
public class addrent extends HttpServlet {
    BookService bookService = BookService.getInstance();
    UserService userService = UserService.getInstance();
    RentService rentService = RentService.getInstance();
    private static Book Sbook;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id1 = req.getParameter("bookId");

        if (id1 == null) {

            List<Book> allBooks = bookService.getAllBooks();
            req.setAttribute("books", allBooks);
            req.getRequestDispatcher("templates/forHome/showbooks.jsp").forward(req, resp);
            return;

        }
        Integer id = Integer.valueOf(req.getParameter("bookId"));
        Book book = bookService.getBookById(id);
        if (book != null) {
            Sbook = book;
            req.getRequestDispatcher("templates/forHome/add-rent.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate date = LocalDate.parse(req.getParameter("toDate"));

        if (Sbook == null) {
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)) {
                req.setAttribute("url", "/admincabinet");
            } else {
                req.setAttribute("url", "/home");
            }
            req.setAttribute("warning", "Kitob Topilmadi");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);

        } else if (Sbook.getQuantity() < 1) {
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)) {
                req.setAttribute("url", "/admincabinet");
            } else {
                req.setAttribute("url", "/home");
            }
            req.setAttribute("warning", "Kitob Qolmadi");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);

        } else if (date.isBefore(LocalDate.now())) {
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)) {
                req.setAttribute("url", "/admincabinet");
            } else {
                req.setAttribute("url", "/home");
            }
            req.setAttribute("warning", "Sana Xato Kiritildi");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);

        }
        else {

            Sbook.setQuantity(Sbook.getQuantity() - 1);
            bookService.updateBook(Sbook);

            User user = MyFilter.getCurrentUser();
            user.setActive(true);
            userService.update(user);

            Rent rent = Rent
                    .builder()
                    .jarima(0.0)
                    .user(user)
                    .to_date(date)
                    .active(true)
                    .book(Sbook)
                    .build();
            rentService.Add(rent);
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)) {
                req.setAttribute("url", "/admincabinet");
            } else {
                req.setAttribute("url", "/home");
            }
            req.setAttribute("success", "Kitob " + date + " sanagacha ijaraga olindi\nShu sanadan o'tgan har bir kun uchun 20.000 dan jarima\nIltimos e'tiborli bo'ling!");
            req.getRequestDispatcher("/templates/SUCCESS.jsp").forward(req, resp);


        }

    }
}
