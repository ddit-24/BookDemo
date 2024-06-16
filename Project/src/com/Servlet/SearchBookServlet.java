package com.Servlet;
import com.Dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.Entity.Book;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.searchBooks(query);
        request.setAttribute("booklist", bookList);
        request.getRequestDispatcher("/Allbook.jsp").forward(request, response);
    }
}
