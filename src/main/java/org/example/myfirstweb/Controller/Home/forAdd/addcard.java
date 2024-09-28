package org.example.myfirstweb.Controller.Home.forAdd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.CardService;
import org.example.myfirstweb.entity.Card;
import org.example.myfirstweb.enums.CardType;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;

@WebServlet("/add-card")
public class addcard extends HttpServlet {
    CardService cardService = CardService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Card card = cardService.findCard(MyFilter.getCurrentUser());
        if (card==null) {
        req.getRequestDispatcher("templates/forHome/add-card.jsp").forward(req, resp);

        }else {

            req.setAttribute("card", card);
            req.getRequestDispatcher("templates/forHome/show-card.jsp").forward(req, resp);

        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double balance = Double.valueOf(req.getParameter("balance"));
        String number = req.getParameter("number");

        if (number.length()!=16){
            req.setAttribute("warning", "card number wrong");
            req.setAttribute("url", "/home");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }



        Card card = Card
                .builder()
                .balance(balance)
                .cardName(name)
                .cardNumber(number)
                .user(MyFilter.getCurrentUser())
                .cardType(CardType.REGISTIRED)
                .build();

        cardService.add(card);
        req.setAttribute("success", "success add card");
        req.setAttribute("url", "/home");
        req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);


    }
}
