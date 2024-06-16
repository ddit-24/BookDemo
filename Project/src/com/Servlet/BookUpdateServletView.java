package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Book;

@WebServlet("/BookUpdateServletView")
public class BookUpdateServletView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Book book=(Book) request.getAttribute("book");
		PrintWriter writer = response.getWriter();
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
		                        +"form{"
		                        +" position:absolute;"
						         +"  left:50%;"
						         +"  top:50%;"
						         +"  transform:translate(-50%,-50%);"
						           
						          +" width:390px;"
						          +" height:400px;"
						          +" border:1px solid #e9dede;"
						          +" border-radius:32px;"
						           +"box-shadow: 0 0 34px #c4c1c1;"
						           +"h2{"
						          +"  text-align:center;"
						           +" color:#65cef1;"
						          +"  height:30px;"
						           +" font-size:26px;"
						           +"  }"
						          +" p{"
						          +"  height:40px;"
						           +" margin-left:24px;"
						           +" input{"
						           +"     width:240px;"
						           +"     height:28px;"
						           +" }"
						           +" select{"
						           +"     width:246px;"
						           +"     height:34px;"
						           +" }"
						           +" }"
						           +".p1{"
						           +"   height:2px;"
						           +"  }"
						           +".btn{"
						            +"   display:block;"
						            +"    margin:24px 0 0 129px;"
						            +"   width:60px;"
						             +"  height:34px;"
						             +"  background:#65cef1;"
						              +" color:white;"
						              +" font-size:20px;"
						              +" border:none;"
						             +"  outline:none;"
						              +" border-radius:5px;"
						              +" }"
						              +" }"
						   +" </style>"
						+"</head>"
						+"<body>"
						    +"<form action='http://localhost:8080/Project/BookUpdateServlet'method='get'>"
						    +"   <h2>�޸�ͼ����Ϣ</h2>"
						    +"    <p class='p1'>&nbsp;<input type=\"hidden\" name='bookid' value='"+book.getBookid()+"'></p>"
						    +"    <p>ͼ������:&nbsp;<input type=\"text\" value='"+book.getBookname()+"' name='bookname'></p>"
						    +"    <p>ͼ��۸�:&nbsp;<input type=\"text\" value='"+book.getPrice()+"' name='price'></p>"
						    +"    <p>ͼ������:&nbsp;<input type=\"text\" value='"+book.getAuthor()+"' name='authors'></p>"
						    +"   <p>ͼ�����:&nbsp;<select name='categoryid'>");
		//
		if(book.getCategoryid()==1){
			writer.print("<option selected value='1'>С˵</option>"
				         +"<option value='2'>ɢ��</option>"
				         +"<option value='3'>��ʷ</option>"
				         +"<option value='4'>����</option>");
		}
		if(book.getCategoryid()==2){
			writer.print("<option value='1'>С˵</option>"
				         +"<option selected  value='2'>ɢ��</option>"
				         +"<option value='3'>��ʷ</option>"
				         +"<option value='4'>����</option>");
		}
		if(book.getCategoryid()==3){
			writer.print("<option value='1'>С˵</option>"
				         +"<option  value='2'>ɢ��</option>"
				         +"<option selected value='3'>��ʷ</option>"
				         +"<option value='4'>����</option>");
		}
		if(book.getCategoryid()==4){
			writer.print("<option value='1'>С˵</option>"
				         +"<option value='2'>ɢ��</option>"
				         +"<option value='3'>��ʷ</option>"
				         +"<option selected value='4'>����</option>");
		}
		
		
		writer.print("</p>"
				     +" <p><input type=\"submit\" value=\"�޸�\" class=\"btn\"></p>"
				     +"  </form>"
				+"</body>"
				+"</html>");
		
		
		
		
		
		
		
		
		
		
	}

}
