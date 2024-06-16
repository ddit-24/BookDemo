package com.Servlet;

import com.Entity.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;


@WebServlet("/BookSelectAllServletView")
public class BookSelectAllServletView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		List<Book> booklist = (List<Book>) request.getAttribute("booklist");
		writer.print("<!DOCTYPE html>"
		                +"<html lang=\"en\">"
		                +"<head>"
		                    +"<meta charset=\"UTF-8\">"
		                    +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
		                    +"<title>Document</title>"
		                    +"<style>"
		                        +"html,body{"
		                            +"width:100vw;"
		                        +"}"
		                        +"table{"
		                            +"width:80%;"
		                            +"border:1px solid #16e3ea;"
		                            +"margin:60px auto;"
		                        +"}"
		                        +"tr{"
		                            +"width:100%;"
		                            +"height:39px;"
		                        +"}"
		                        +"th{"
		                            +"background:#a2f4ff;"
		                        +"}"
		                        +"td{"
			                        +"width:188px;"
		                            +"height:39px;"
		                            +"background:#efefef;"
		                            +"text-align:center;"
		                        +"}"
		                        +"button{"
		                        +"     width:60px;"
		                            +"    height:30px;"
		                            +"    font-size:18px;"
		                            +"   border:1px solid #ea6666;"
		                             +"   color:#2ed9f0;"
		                              +"  border-radius:9px;"
		                              +" }"
		                           +" button:hover{"
		                            +"   background:#a8fcff;"
		                            +"   border:none;"
		                            +"    color:white;"
		                            +" }"
		                    +"</style>"
		                +"</head>"
		                +"<body>"
		                    +"<table>"
		                        +"<tr>"
		                            +"<th>图书id</th>"
		                            +"<th>书名</th>"
		                            +"<th>价格</th>"
		                            +"<th>作者</th>"
		                            +"<th>类别</th>"	
		                            +"<th>操作</th>"	
		                        +"</tr>");
		//for遍历
		for(Book book:booklist){
			writer.print("<tr>"
							+"<td>"+book.getBookid() +"</td>"
							+"<td>"+book.getBookname() +"</td>"
				            +"<td>"+book.getPrice() +"</td>"
				            +"<td>"+book.getAuthor() +"</td>"
				            +"<td>"+book.getCategoryname() +"</td>"
				            +"<td><a href='http://localhost:8080/Project/BookDeleteOneServlet?bookid="+book.getBookid()+"'><button>删除</button></a>"
				            +"   <a href='http://localhost:8080/Project/BookSelectByIdServlet?bookid="+book.getBookid()+"'><button>修改</button></a> "
				            + "</td>"
				        +"</tr>");
		}
		writer.print("</table>"
					+"</body>"
					+"</html>");					  
	}
}
