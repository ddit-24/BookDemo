package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.IORInterceptor;

import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/BookDeleteAllServlet")
public class BookDeleteAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String[] stringbookids = request.getParameterValues("bookids");
		for(int i=0;i<stringbookids.length;i++){
			int bookid = Integer.parseInt(stringbookids[i]);
			BookService bs=new BookServiceImpl();
			bs.DeleteBookOne(bookid);
		}
		response.sendRedirect("/Project/BookSelectAllServlet");
	}

}
