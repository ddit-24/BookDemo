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
import com.Entity.User;

import cn.hutool.db.Session;

public class UserLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	   // String charset;
		response.setContentType("text/html");
		//huuoqu 
		PrintWriter writer = response.getWriter();
		
		//��ȡ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//
		request.setAttribute("username", username);
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String stringcode = (String)session.getAttribute("code");
		
		//
		if(stringcode.equals(code)){
			System.out.println("ǰ�˴���"+username+"---"+password);
			User user = new User(username,password);
			UserDao usd = new UserDaoImpl();
			//����Dao��ĵ�¼����
			User u = usd.selectUser(user);
			
			if(u==null){
				writer.print("û��ע��");
			}else{
				session.setAttribute("user", u);
				writer.print("��¼�ɹ�");
				//�ض���
				//response.sendRedirect("/Project/BookSelectAllServlet");
				//ת�� ����Ҫ��Ŀ��
				request.getRequestDispatcher("/BookSelectAllServlet").forward(request, response);
			}
		}
		else{
			response.sendRedirect("/Project/login.jsp");
		}
		
	}

}
