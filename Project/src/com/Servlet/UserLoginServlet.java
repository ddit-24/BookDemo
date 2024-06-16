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
		
		//获取
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//
		request.setAttribute("username", username);
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String stringcode = (String)session.getAttribute("code");
		
		//
		if(stringcode.equals(code)){
			System.out.println("前端传的"+username+"---"+password);
			User user = new User(username,password);
			UserDao usd = new UserDaoImpl();
			//调用Dao层的登录方法
			User u = usd.selectUser(user);
			
			if(u==null){
				writer.print("没有注册");
			}else{
				session.setAttribute("user", u);
				writer.print("登录成功");
				//重定向
				//response.sendRedirect("/Project/BookSelectAllServlet");
				//转发 不需要项目名
				request.getRequestDispatcher("/BookSelectAllServlet").forward(request, response);
			}
		}
		else{
			response.sendRedirect("/Project/login.jsp");
		}
		
	}

}
