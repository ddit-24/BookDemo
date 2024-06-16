package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.User;

public class UserRegisterServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 request.setCharacterEncoding("utf-8");
			    response.setCharacterEncoding("utf-8");
		    String charset;
			response.setContentType("text/html");
			//huuoqu 
			PrintWriter writer = response.getWriter();
			
			//获取
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("前端传的"+username+"---"+password);
			User user = new User(username,password);
			UserDao usd = new UserDaoImpl();
		  User u = usd.selectUser(user);
			if(u==null){
			//调用Dao层的登录方法
			  int i=usd.useradd(user);
			  writer.print("注册成功");
			  response.sendRedirect("login.jsp");
			}
			else{
				writer.print("注册失败");
			}
		}	
	}

	



