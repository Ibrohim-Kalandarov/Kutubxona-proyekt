package org.example.myfirstweb.Controller.Admin.ichkiController.forRent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.entity.Rent;

import java.io.IOException;
import java.util.List;

@WebServlet("/showactiverents")
public class showactiverents extends HttpServlet {
    RentService service= RentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent> activeiveRents = service.getActiveiveRents();
        req.setAttribute("rents", activeiveRents);
        req.setAttribute("malumot","Barcha Active Ijaralar");
        req.getRequestDispatcher("templates/forAdmin/showrents.jsp").forward(req, resp);

    }
}
