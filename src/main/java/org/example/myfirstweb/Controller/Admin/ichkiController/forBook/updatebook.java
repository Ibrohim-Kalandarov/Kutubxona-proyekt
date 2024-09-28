package org.example.myfirstweb.Controller.Admin.ichkiController.forBook;

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

@WebServlet("/updatebook")
public class updatebook extends HttpServlet {
    BookService bookService = BookService.getInstance();
    CategoryService categoryService = CategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> allCategory = categoryService.getAllCategory();
        req.setAttribute("categories", allCategory);
        Integer id = Integer.valueOf(req.getParameter("bookId"));
        Book book = bookService.getBookById(id);
        if (book != null) {
            req.setAttribute("book", book);
            req.getRequestDispatcher("templates/forAdmin/updatebook.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));

        Integer id = Integer.valueOf(req.getParameter("id"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        String title = req.getParameter("title");
        Category category = categoryService.getCategory(categoryId);

        Book book = bookService.getBookById(id);
        if (book != null) {
            book.setCategory(category);
            book.setPrice(price);
            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);
            book.setPublisher(publisher);
            book.setQuantity(quantity);
            bookService.updateBook(book);
            req.setAttribute("success", "Book updated");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("templates/SUCCESS.jsp").forward(req, resp);

        } else {
            req.setAttribute("warning", "Book not found");
            req.setAttribute("url", "/admincabinet");
            req.getRequestDispatcher("templates/WARNING.jsp").forward(req, resp);

        }


    }

}
