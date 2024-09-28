package org.example.myfirstweb.Controller.Admin.ichkiController.malumot;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BuyService;
import org.example.myfirstweb.entity.Buy;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-buy-books-admin")
public class sotib_olingan_kitoblar extends HttpServlet {
    BuyService buyService = BuyService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Buy> buys = buyService.getlll();
        if (buys.isEmpty()) {
            req.setAttribute("warning", "hali kitob sotilmagan");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("buys", buys);
        req.getRequestDispatcher("templates/forAdmin/show-buys.jsp").forward(req, resp);

    }
}
