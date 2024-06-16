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
		System.out.println("����bookid"+bookid);
		//�����ܻ�ȡbookid
		BookService bs=new BookServiceImpl();
		Book book=bs.SelectById(bookid);
		//����������
		request.setAttribute("book", book);
		//System.out.println("���������book��"+book);
		//����bookid��ȡ����book����ʱ����ȡ�� ��ȷ
		//ת��
//		request.getRequestDispatcher("/BookUpdateServletView").forward(request, response);
		request.getRequestDispatcher("/Changebook.jsp").forward(request, response);
	
	
	}

}
