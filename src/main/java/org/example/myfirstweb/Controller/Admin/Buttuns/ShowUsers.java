package org.example.myfirstweb.Controller.Admin.Buttuns;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/showusers")
public class ShowUsers extends HttpServlet {
    UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);
        req.setAttribute("malumot","Barcha Userlar");
        RequestDispatcher dispatcher = req.getRequestDispatcher("templates/forAdmin/showusers.jsp");
        dispatcher.forward(req, resp);
    }
}
