package org.example.myfirstweb.Controller.Admin.ichkiController.forUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/showpassiveusers")
public class showpassiveusers extends HttpServlet {
    UserService service= UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> passiveUsers = service.getPassiveUsers();
        req.setAttribute("users", passiveUsers);
        req.setAttribute("malumot","Barcha Passive Userlar");
        req.getRequestDispatcher("templates/forAdmin/showusers.jsp").forward(req, resp);


    }
}
