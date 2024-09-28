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

@WebServlet("/showactiveusers")
public class showactiveusers extends HttpServlet {
    UserService service= UserService.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> activeUsers = service.getActiveUsers();
        req.setAttribute("users", activeUsers);
        req.setAttribute("malumot","Barcha Faol Userlar");
        req.getRequestDispatcher("templates/forAdmin/showusers.jsp").forward(req, resp);
    }
}
