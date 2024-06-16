package com.Servlet;

import java.io.IOException;
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


@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("用户user"+user);
		//
		if(user!=null){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		    String stringbookid = request.getParameter("bookid");
		    //
		    int bookid = Integer.parseInt(stringbookid);
			String bookname = request.getParameter("bookname");
			String stringprice = request.getParameter("price");
			double price = Double.parseDouble(stringprice);
			String author = request.getParameter("authors");
			String stringcategoryid = request.getParameter("categoryid");
			int categoryid = Integer.parseInt(stringcategoryid);
			System.out.println(categoryid);
			Book book= new Book(bookid,bookname,price,author,categoryid);
			BookService bs = new BookServiceImpl();
			bs.UpdateById(book);
			//重定向加文件名
			response.sendRedirect("/Project/BookSelectAllServlet");
		}
		else{
			response.sendRedirect("/Project/login.jsp");
		}
		
	}

}
