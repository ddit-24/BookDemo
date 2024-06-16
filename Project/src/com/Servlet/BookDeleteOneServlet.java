package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Book;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/BookDeleteOneServlet")
public class BookDeleteOneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		BookService bs = new BookServiceImpl();	
		PrintWriter writer = response.getWriter();
		String stringbookid = request.getParameter("bookid");
		int bookid = Integer.parseInt(stringbookid);
		//request.setAttribute("bookid", bookid);
		bs.DeleteBookOne(bookid);
		
		request.getRequestDispatcher("/BookSelectAllServlet").forward(request, response);
		
	}

}
