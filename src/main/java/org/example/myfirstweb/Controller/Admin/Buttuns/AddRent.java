package org.example.myfirstweb.Controller.Admin.Buttuns;

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

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addrent")
public class AddRent extends HttpServlet {
    RentService rentservice = RentService.getInstance();
    UserService userservice = UserService.getInstance();
    BookService bookservice = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/forAdmin/addrent.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userid = Integer.valueOf(req.getParameter("userId"));
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        LocalDate date = LocalDate.parse(req.getParameter("toDate"));

        Book book = bookservice.getBookById(bookId);
        User user = userservice.findById(userid);

        if (book == null) {
            req.setAttribute("warning", "book not found");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);
        } else if (user == null) {
            req.setAttribute("warning", "User not found");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);
        } else if (book.getQuantity() < 1) {
            req.setAttribute("warning", "Kitob Qolmadi");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);
        } else if (date.isBefore(LocalDate.now())) {
            req.setAttribute("warning", "Sana Xato Kiritildi");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);
        } else {

            book.setQuantity(book.getQuantity() - 1);
            bookservice.updateBook(book);

            user.setActive(true);
            userservice.update(user);

            Rent rent = Rent
                    .builder()
                    .jarima(0.0)
                    .user(user)
                    .to_date(date)
                    .active(true)
                    .book(book)
                    .build();
            rentservice.Add(rent);


            req.setAttribute("success", "Kitob " + date + " sanagacha ijaraga olindi\nShu sanadan o'tgan har bir kun uchun 20.000 dan jarima\nIltimos e'tiborli bo'ling!");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("/templates/SUCCESS.jsp").forward(req, resp);


        }

    }
}

