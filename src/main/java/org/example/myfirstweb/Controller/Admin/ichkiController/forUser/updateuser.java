package org.example.myfirstweb.Controller.Admin.ichkiController.forUser;

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

@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
    UserService service = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User byEmail = service.findByEmail(email);

        if (byEmail!=null) {
            User user = byEmail;
            req.setAttribute("user", user);
            req.getRequestDispatcher("templates/forAdmin/updateuser.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String username = req.getParameter("name");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        User user = service.findById(id);
        if (user!=null) {
            String code = generateCode();
            if (!user.getEmail().equals(email)) {
                boolean check = service.check(email);
                if (!check) {
                    req.setAttribute("warning", "email already exists");
                    req.setAttribute("url","/signup");
                    try {
                        req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
                    } catch (ServletException e) {
                    } catch (IOException e) {
                    }

                }else {
                executorService.submit(() -> {
                    try {

                        String salom = "Salom sizning bazi ma'lumotlaringizni o'zgartirmoqchimiz tasdiqlash uchun kodni kiriting";
                        SendMessage.sendEmail(salom, email, code);
                        user.setCode(code);
                        service.update(user);
                    } catch (MessagingException e) {
                    }

                });
                }

                try {

                    String s = (user.getEmail() + "#" + email);


                    req.setAttribute("email", s);
                    req.getRequestDispatcher("templates/inout/auth.jsp").forward(req, resp);
                } catch (ServletException e) {
                } catch (IOException e) {
                }

            }
            else {
                user.setName(username);
                user.setAge(Integer.parseInt(age));
                user.setPassword(password);
                if (role != null) {
                    if (role.equals("ADMIN")) {
                    user.setRole(Role.ADMIN);

                    }
                    else {
                        user.setRole(Role.USER);
                    }
                }
                service.update(user);
            }







        }
        else {
            req.setAttribute("message", "user not found");

        }


        resp.sendRedirect("/showusers");

    }

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(new Random().nextInt(0, 10));
        }
        return sb.toString();

    }
}
