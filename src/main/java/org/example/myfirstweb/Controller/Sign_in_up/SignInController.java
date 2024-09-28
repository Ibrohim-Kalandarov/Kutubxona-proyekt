package org.example.myfirstweb.Controller.Sign_in_up;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.myfirstweb.SendMessegeEmail.SendMessage;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;

import java.io.IOException;
import java.util.Random;

@WebServlet("/signin")
public class SignInController extends HttpServlet {
    UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/inout/signin.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.findByEmail(email);

        if (user==null) {
            req.setAttribute("warning", "user not found");
            req.setAttribute("url","/signup");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        if (user.getPassword().equals(password) && user.getRole().equals(Role.USER)) {

            resp.sendRedirect("/home");

        }
        else if (user.getPassword().equals(password) && user.getRole().equals(Role.ADMIN)) {
            resp.sendRedirect("/admincabinet");
        }
        else if (user.getPassword().equals(password) && user.getRole().equals(Role.NONUSER)) {

            try {
                String code = generateCode();
                SendMessage.sendEmail("Ro'yxatdan o'tish uchun smsni kiriting", email, code);
                user.setCode(code);
                userService.update(user);
                System.out.println("email: " + user.getEmail()+"code: " + user.getCode());
            } catch (MessagingException e) {}

            req.setAttribute("email", email);
            req.getRequestDispatcher("templates/inout/retryauth.jsp").forward(req, resp);

        }
        else {
            req.setAttribute("warning", "code wrong");
            req.setAttribute("url","/signup");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);

        }
    }

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        int rand = 0;
        for (int i = 0; i < 6; i++) {
            sb.append(new Random().nextInt(0, 10));

        }
        return sb.toString();

    }

}