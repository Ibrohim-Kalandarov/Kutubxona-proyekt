package org.example.myfirstweb.Controller.Home.forShow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.entity.Rent;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-rent")
public class showrent extends HttpServlet {
    RentService rentService=RentService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Rent> rents = rentService.getPassiveRents(MyFilter.getCurrentUser());

        if (rents.isEmpty()){
            req.setAttribute("warning","rent is empty");
            req.setAttribute("url","/home");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("rents", rents);
        req.getRequestDispatcher("templates/forHome/showpassiverent.jsp").forward(req, resp);


    }
}
