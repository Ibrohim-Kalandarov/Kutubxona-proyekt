package org.example.myfirstweb.Controller.Home.forAdd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.CardService;
import org.example.myfirstweb.entity.Card;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;

@WebServlet("/add-amount")
public class addamout extends HttpServlet {
    CardService cardService=CardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("templates/forHome/add-amout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Double balance = Double.valueOf(req.getParameter("balance"));
        Card card = cardService.findCard(MyFilter.getCurrentUser());
        card.setBalance(card.getBalance()+balance);
        cardService.update(card);
        req.setAttribute("success", "success add amount");
        req.setAttribute("url", "/home");
        req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);


    }
}
