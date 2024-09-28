package org.example.myfirstweb.Controller.Home.forReturnDelete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.Rent;
import org.example.myfirstweb.enums.Role;
import org.example.myfirstweb.filter.MyFilter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@WebServlet("/return-rent")
public class returnrent extends HttpServlet {
    RentService rentService=RentService.getInstance();
    BookService bookService=BookService.getInstance();
    UserService userService=UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent> activeRents = rentService.getActiveRents(MyFilter.getCurrentUser());
        if (activeRents.isEmpty()) {
            req.setAttribute("warning", "Active rents is empty");
            req.setAttribute("url", "/home");
            req.getRequestDispatcher("/templates/WARNING.jsp").forward(req, resp);

        }else {
            req.setAttribute("rents", activeRents);
            req.getRequestDispatcher("templates/forHome/returnrent.jsp").forward(req, resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));


        Rent rent = rentService.getRent(id);
        if (rent != null && rent.isActive()) {
            double jarima = 0.0;
            LocalDate toDate = rent.getTo_date();
            LocalDate now = LocalDate.now();
            if (toDate.isBefore(now))  {

                long daysBetween = ChronoUnit.DAYS.between(toDate, now);
                System.out.println("daysBetween: "+daysBetween);
                if (daysBetween > 0) {
                    jarima = (double) (daysBetween * 20000);
                } else {
                    jarima = 0.0;
                }

            }
            long l = rentService.countUserActiveRents(rent.getUser());
            if (l == 1 ) {
                rent.getUser().setActive(false);
                userService.update(rent.getUser());
            }


            rent.getBook().setQuantity(rent.getBook().getQuantity() + 1);
            bookService.updateBook(rent.getBook());
            rent.setActive(false);
            rent.setJarima(jarima);
            rentService.updateRent(rent);

            req.setAttribute("success", "Ijara qaytarildi!");
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)){
                req.setAttribute("url", "/admincabinet");
            }else {
            req.setAttribute("url", "/home");
            }
            req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);



        } else {
            req.setAttribute("warning", "ijara avval qaytarilgan!");
            if (MyFilter.getCurrentUser().getRole().equals(Role.ADMIN)){
                req.setAttribute("url", "/admincabinet");
            }else {
                req.setAttribute("url", "/home");
            }
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);

        }



    }
}
