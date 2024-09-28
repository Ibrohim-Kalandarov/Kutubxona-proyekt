package org.example.myfirstweb.Controller.Admin.ichkiController.forUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.RentService;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;

import java.io.IOException;

@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet {
    UserService service = UserService.getInstance();
    RentService rentService = RentService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        User user = service.findById(id);
        if (user != null) {
            long l = rentService.countUserAllRents(user);
            if (l > 0) {
                req.setAttribute("warning", "userni active renti bor");
                req.setAttribute("url", "/showusers");
                req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            } else {
                service.delete(id);
                resp.sendRedirect("/showusers");
            }

        }else {
            req.setAttribute("warning", "user not found");
            req.setAttribute("url", "/showusers");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
        }


    }
}
