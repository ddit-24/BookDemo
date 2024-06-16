package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Book;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/BookSelectByIdServlet")
public class BookSelectByIdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String stringbookid = request.getParameter("bookid");
		int bookid = Integer.parseInt(stringbookid);
		System.out.println("这是bookid"+bookid);
		//这里能获取bookid
		BookService bs=new BookServiceImpl();
		Book book=bs.SelectById(bookid);
		//设置请求体
		request.setAttribute("book", book);
		//System.out.println("这是输出的book："+book);
		//根据bookid获取整个book对象时，获取争 正确
		//转发
//		request.getRequestDispatcher("/BookUpdateServletView").forward(request, response);
		request.getRequestDispatcher("/Changebook.jsp").forward(request, response);
	
	
	}

}
