package org.example.myfirstweb.Controller.Sign_in_up;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.SendMessegeEmail.SendMessage;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;

import java.io.IOException;
import java.util.Random;

import static org.example.myfirstweb.db.Datasource.executorService;

@WebServlet("/retryauth")
public class RetryAuth extends HttpServlet {
    UserService service = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User userf = service.findByEmail(email);
        if (userf==null) {
            req.setAttribute("warning", "user not found");
            req.setAttribute("url","/signup");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        String code = generateCode();
        User user = userf;
        executorService.submit(()->{
            try {
                SendMessage.sendEmail("Kodni kiriting", email, code);
                user.setCode(code);
                service.update(user);
                System.out.println("email: " + user.getEmail()+"code: " + user.getCode());
            } catch (MessagingException e) {}
            req.setAttribute("email", email);

        });
        req.getRequestDispatcher("templates/inout/retryauth.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User userf = service.findByEmail(email);
        if (userf!=null) {
            User user = userf;
            if (code.equals(user.getCode())) {
                user.setCode(code);
                user.setRole(Role.USER);
                service.update(user);
                resp.sendRedirect("/signin");
            } else {
                req.setAttribute("warning", "code incorrect");
                req.setAttribute("url","/signup");
                req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);

            }
        } else {
            req.setAttribute("warning", "user does not exist");
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
