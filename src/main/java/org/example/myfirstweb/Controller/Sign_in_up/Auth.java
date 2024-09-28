package org.example.myfirstweb.Controller.Sign_in_up;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;

import java.io.IOException;


@WebServlet("/auth")
public class Auth extends HttpServlet {
    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/inout/auth.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emails = req.getParameter("email");
        String code = req.getParameter("code");


        if (code.length() == 6) {
            User user = userService.findByEmail(emails);

            if (user!=null) {


                if (code.equals(user.getCode())) {
                    user.setRole(Role.USER);
                    userService.update(user);
                    resp.sendRedirect("/signin");
                }
            }
        }
        else if (code.length() == 7) {
            String[] parts = emails.split("#");
            String Hemail = parts[0];
            String Uemail = parts[1];
            boolean check = userService.check(Uemail);
            if (check) {

                User userf = userService.findByEmail(Hemail);


                if (userf!=null) {
                    User user = userf;

                    if (code != null) {

                        if (code.equals(user.getCode())) {
                            user.setEmail(Uemail);
                            userService.update(user);
                            resp.sendRedirect("/signin");
                        }

                    }
                }
            } else {
                req.setAttribute("warning", "email already exists");
                req.setAttribute("url","/signup");
                req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
return;
            }


        }
        else {
            req.setAttribute("warning", "code wrong");
            req.setAttribute("url","/signup");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);

        }


    }
}
