package com.Servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Book;
import com.Entity.Category;

@WebServlet("/CategorySelectAllServiceView")
public class CategorySelectAllServiceView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取转发的数据
		List<Category> Categorylist = (List<Category>) request.getAttribute("Categorylist");
		
		PrintWriter writer = response.getWriter();
		writer.print("<!DOCTYPE html>"
                +"<html lang=\"en\">"
                +"<head>"
                    +"<meta charset=\"UTF-8\">"
                    +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    +"<title>Document</title>"
                    +" <style>"
                    +"  html,body{"
                    +"     height:100%;"
                    +"  }"
				       +" table{"
				        +"   margin:50px auto;"
				        +"   min-height:38px;"
				        +"   max-height:100%;"
				        +"    width:300px;"
				         +"   border:1px solid #e09e9e;"
				         +"   border-collapse: collapse;"
				         +"   tr{"
				         +"      height:38;"
                        +"       border:1px solid #e09e9e;"
                         +"   }"
				         +"   th{"
				         +"       height:38px;"
				         +"       border:1px solid #e09e9e;"
				         +"   }"
				          +"  td{"
				          +"      height:38px;"
				          +"      border:1px solid #e09e9e;"
				           +"     width:150px;"
				           +"     text-align:center;"
				           +" }"
				           +" }"
				   +"</style>"
				+"</head>"
				+"<body>"
				+"    <table>"
				 +"       <tr>"
				  +"          <th>图书id</th>"
				  +"          <th>图书类名</th>"
				   +"     </tr>");
        //for遍历
		for(Category list:Categorylist){
			writer.print("<tr>"
							+"<td>"+list.getCategoryid() +"</td>"
							+"<td>"+list.getCategoryname() +"</td>"
				        +"</tr>");
		}
		writer.print("</table>"
				+"</body>"
				+"</html>");		
	}

}
