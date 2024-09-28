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

@WebServlet("/showpassiverents")
public class showpassiverents extends HttpServlet {
    RentService service=RentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Rent> passiveRents = service.getPassiveRents();
        req.setAttribute("rents", passiveRents);
        req.getRequestDispatcher("templates/forAdmin/showpassiverents.jsp").forward(req, resp);
    }
}
