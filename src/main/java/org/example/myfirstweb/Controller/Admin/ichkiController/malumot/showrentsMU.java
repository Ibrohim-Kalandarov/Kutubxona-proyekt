package org.example.myfirstweb.Controller.Admin.ichkiController.malumot;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.entity.Rent;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-rents-MU")
public class showrentsMU extends HttpServlet {
    RentService rentService=RentService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent> rents = rentService.findAllJarima();
        if (rents.isEmpty()){
            req.setAttribute("warning","jarimali ijaralar yo'q");
            req.setAttribute("url","/admincabinet");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("rents", rents);
        req.setAttribute("malumot","Topshirilmagan ijaralar");
        req.getRequestDispatcher("templates/forAdmin/Umalumot.jsp").forward(req, resp);


    }
}
