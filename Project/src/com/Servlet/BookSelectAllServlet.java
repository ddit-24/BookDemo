package com.Servlet;

import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.Book;
import com.Entity.User;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/BookSelectAllServlet")
public class BookSelectAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//��ȡname
			String username = (String) request.getAttribute("username");
			request.setAttribute("username",username);
			BookService bs = new BookServiceImpl();	
			List<Book> booklist = bs.SelectAllBook();
			PrintWriter writer = response.getWriter();
			writer.print(booklist);
			//���м�����
			System.out.println(booklist.size());
			//���ÿһ�������飬�˴�categoryid����
			for(Book book :booklist){
				System.out.println(book);
				writer.print(book);
			}
			request.setAttribute("booklist", booklist);
			
			request.getRequestDispatcher("/Allbook.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("/Project/login.jsp");
		}
	}

}
