package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.Book;
import com.Entity.User;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("�û�user"+user);
		//
		if(user!=null){
			request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    //��ȡname
			String username = (String) request.getAttribute("username");
			request.setAttribute("username",username);
			//
			String bookname = request.getParameter("bookname");
			String stringprice = request.getParameter("price");
			double price = Double.parseDouble(stringprice);
			String author = request.getParameter("authors");
			String stringcategoryid = request.getParameter("categoryid");
			int categoryid = Integer.parseInt(stringcategoryid);
			//������ӵ�book������String bookname, double price, String author, int categoryid
			Book book = new Book(bookname,price,author,categoryid);
			PrintWriter writer = response.getWriter();
			BookService bs = new BookServiceImpl();
			boolean bookboolean = bs.BookAdd(book);
		
			UserDao usd = new UserDaoImpl();
			//����Dao��ĵ�¼����
			User u = usd.selectUser(user);
			if(u==null){
				response.sendRedirect("/Project/login.jsp");
			}
			else{
				if(bookboolean){
					//writer.print("ͼ����ӳɹ�");
					//bs.BookAdd(book);
					//��ת  �ض���
					response.sendRedirect("/Project/BookSelectAllServlet");
				}
				else{
				 writer.print("ͼ���Ѵ���");
				}
			}
		}
		else{
			response.sendRedirect("/Project/login.jsp");
			return;
		}		
	}

}
