package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import com.Entity.Book;

@WebServlet("/JSPDemoServlet")
public class JSPDemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int num=13;
		Book book = new Book("»î×Å", 55.9,"Óà»ª", 2);
		request.setAttribute("num", num);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
