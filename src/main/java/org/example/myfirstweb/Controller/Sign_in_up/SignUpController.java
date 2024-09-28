package org.example.myfirstweb.Controller.Sign_in_up;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.myfirstweb.SendMessegeEmail.SendMessage;
import org.example.myfirstweb.Service.UserService;
import org.example.myfirstweb.entity.Cart;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;

import java.io.IOException;
import java.util.Random;

import static org.example.myfirstweb.db.Datasource.executorService;


@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    UserService service = UserService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/inout/signup.jsp").forward(req, resp);

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String code = generateCode();
        executorService.submit(()->{
            try {
                SendMessage.sendEmail("Ro'yxatdan o'tish uchun kodni kiriting", email, code);
            } catch (MessagingException e) {}

        });

        boolean check = service.check(email);
        if (!check) {
            req.setAttribute("warning", "email already exists");
            req.setAttribute("url","/signup");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;

        }
Cart cart = new Cart();
        service.addCart(cart);


        User user =
                User
                        .builder()
                        .name(name)
                        .age(age)
                        .email(email)
                        .password(password)
                        .cart(cart)
                        .active(false)
                        .role(Role.NONUSER)
                        .code(code)
                        .build();

        service.add(user);





        req.setAttribute("email", email);
        req.getRequestDispatcher("templates/inout/auth.jsp").forward(req, resp);


    }


    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(new Random().nextInt(0, 10));
        }
        return sb.toString();

    }
}
