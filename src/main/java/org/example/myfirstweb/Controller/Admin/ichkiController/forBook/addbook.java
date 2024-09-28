package org.example.myfirstweb.Controller.Admin.ichkiController.forBook;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.BookService;
import org.example.myfirstweb.Service.CategoryService;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.entity.Category;

import java.io.IOException;
import java.util.List;

@WebServlet("/addbook")
public class addbook extends HttpServlet {
    BookService bookService = BookService.getInstance();
    CategoryService categoryService = CategoryService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> allCategory = categoryService.getAllCategory();
        request.setAttribute("categories", allCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/forAdmin/addbook.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("categoryId"));
        String author = req.getParameter("author");
        String quantity = req.getParameter("quantity");
        String isbn = req.getParameter("isbn");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        String title = req.getParameter("title");
        Category category = categoryService.getCategory(id);


        Book book = Book
                .builder()
                .category(category)
                .quantity(Integer.valueOf(quantity))
                .author(author)
                .isbn(isbn)
                .price(price)
                .publisher(publisher)
                .title(title)
                .build();
        bookService.addBook(book);
        req.setAttribute("success", "add new book");
        req.setAttribute("url", "/admincabinet");
        req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);
    }

}
