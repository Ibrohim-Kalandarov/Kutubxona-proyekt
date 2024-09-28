package org.example.myfirstweb.Controller.Home.forAdd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.BuyService;
import org.example.myfirstweb.Service.CardService;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.Buy;
import org.example.myfirstweb.entity.Card;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.filter.MyFilter;

import java.io.IOException;

@WebServlet("/buybook")
public class buybook extends HttpServlet {
    BookService bookService = BookService.getInstance();
    BuyService buyService = BuyService.getInstance();
    CardService cardService=CardService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("bookId"));
        Card card = cardService.findCard(MyFilter.getCurrentUser());
        User user = MyFilter.getCurrentUser();
        Book book = bookService.getBook(id);
        if (book == null) {
            req.setAttribute("warning", "book empty");
            req.setAttribute("url", "/home");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }

        boolean b = cardService.find(MyFilter.getCurrentUser());
        if (!b) {
            req.setAttribute("warning", "card empty");
            req.setAttribute("url", "/add-card");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
            return;
        }else {

            if (card == null) {
                req.setAttribute("warning", "card qo'shish uchun back tugmasini bosing");
                req.setAttribute("url", "/add-card");
                req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
                return;
            }else {

                if (card.getBalance()<book.getPrice()) {
                    req.setAttribute("warning", "balance not enough");
                    req.setAttribute("url", "/add-amount");
                    req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);
                    return;
                }
            }
        }

        Buy buy =
                Buy
                        .builder()
                        .book(book)
                        .user(user)
                        .quantity(1)
                        .build();
        buyService.add(buy);
        book.setQuantity(book.getQuantity() - 1);
        bookService.updateBook(book);
        double sum = card.getBalance() - book.getPrice();
        card.setBalance(sum);
        cardService.update(card);

        req.setAttribute("success", "success");
        req.setAttribute("url", "/home");
        req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);

    }
}
