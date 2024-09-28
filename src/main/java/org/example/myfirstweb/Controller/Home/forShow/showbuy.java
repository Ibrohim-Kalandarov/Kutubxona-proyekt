package org.example.myfirstweb.Controller.Home.forShow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BuyService;
import org.example.myfirstweb.entity.Buy;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-buy")
public class showbuy extends HttpServlet {
    BuyService buyService = BuyService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Buy> all = buyService.getUserBuy(MyFilter.getCurrentUser());
        if (all.isEmpty()){
            req.setAttribute("warning","buy table is empty");
            req.setAttribute("url","/home");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("buys", all);
        req.getRequestDispatcher("templates/forHome/showbuy.jsp").forward(req, resp);

    }
}
