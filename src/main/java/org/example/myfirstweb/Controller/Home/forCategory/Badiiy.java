package org.example.myfirstweb.Controller.Home.forCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.myfirstweb.Service.CategoryService;
import org.example.myfirstweb.entity.Book;
import org.example.myfirstweb.enums.CategoryName;

import java.io.IOException;
import java.util.List;

@WebServlet("/category_badiiy")
public class Badiiy extends HttpServlet {
    CategoryService categoryService=CategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> allCategoryBooks = categoryService.getAllCategoryBooks(CategoryName.Badiiy);
        req.setAttribute("books", allCategoryBooks);
        req.getRequestDispatcher("templates/forHome/category.jsp").forward(req, resp);

    }
}
