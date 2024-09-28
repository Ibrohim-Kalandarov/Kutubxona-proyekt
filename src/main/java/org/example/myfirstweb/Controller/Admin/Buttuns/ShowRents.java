package org.example.myfirstweb.Controller.Admin.Buttuns;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.entity.Rent;

import java.io.IOException;
import java.util.List;

@WebServlet("/showrents")
public class ShowRents extends HttpServlet {
    RentService rentService = RentService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent> rents = rentService.getRents();
        req.setAttribute("rents", rents);
        req.setAttribute("malumot","Barcha Ijaralar");
        req.getRequestDispatcher("templates/forAdmin/showrents.jsp").forward(req, resp);



    }
}
