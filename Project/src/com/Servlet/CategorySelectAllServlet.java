package com.Servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Category;
import com.Service.CategoryService;
import com.ServiceImpl.CategoryServiceImpl;

@WebServlet("/CategorySelectAllServlet")
public class CategorySelectAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//调用dao层方法
		CategoryService cs =new CategoryServiceImpl();
		List<Category>  Categorylist =cs.selectList();
		request.setAttribute("Categorylist", Categorylist);
		request.getRequestDispatcher("/Category.jsp").forward(request, response);
		
	}

}
