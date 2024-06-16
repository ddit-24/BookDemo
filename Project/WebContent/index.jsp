<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.Entity.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <p>hello world-index</p>
   <%
     int n= (int)request.getAttribute("num");
     Book book = (Book) request.getAttribute("book");
   %>
   <p><%= n %>
      <%= book.getBookname() %>
    </p>
</body>
</html>