<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List" %>
    <%@ page  import="com.Entity.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>分类</title>
  <style>
       
        body{
          height:100vh;
          background:linear-gradient(#f3daad,pink);
           margin:0;
           padding:0;
           height: 100vh; 
         }
		 table{
		     box-sizing:border-box;
			 margin:70px auto;
			width:300px;
			border:1px solid #E6A23C;
			  border-collapse: collapse;
			 tr{
			   height:38px;
                   border:1px solid #E6A23C;
                }
			 th{
				     height:38px;
				        border:1px solid #E6A23C;
				}
			 td{
				height:38px;
				 border:1px solid #E6A23C;
				   width:150px;
				   text-align:center;
				    }
				   }
	</style>
 </head>
 <body>
   <table>
	  <tr>
		 <th>图书id</th>
		 <th>图书类名</th>
	  </tr>
   <% List<Category> Categorylist = (List<Category>) request.getAttribute("Categorylist"); %>
   <% for(Category list:Categorylist){%>
			<tr>
				<td><%= list.getCategoryid()%></td>
				<td><%=list.getCategoryname() %></td>
			</tr>
	<% 	}%>
	</table>
 </body>
</html>