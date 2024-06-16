<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.Entity.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <style>
		html,body{
		  width:100%;
		  height:100%;
		  background:linear-gradient(to top right, #ffb2b2, #ffeac5, #89cfff, #9affe3);
		}
		form{
		  position:absolute;
		  left:50%;
			top:50%;
			transform:translate(-50%,-50%);
			 width:390px;
			height:400px;
			border:none;
			
			box-shadow: 0 0 34px #a4b2b0;
			
			oopacity:0.5;
		    h2{
				text-align:center;
				color:#65cef1;
				height:30px;
				font-size:26px;
			}
			 p{
				height:40px;
				 margin-left:24px;
				input{
					 width:240px;
					 height:28px;
					 opacity:0.7;
					 outline-color:#f5bb51;
				}
				select{
					 width:246px;
					 height:34px;
					  opacity:0.7;
					  outline-color:#f5bb51;
				 }
			}
			.p1{
				 height:2px;
			}
			.btn{
				display:block;
				margin:24px 0 0 129px;
				width:60px;
				height:34px;
				background:#65cef1;
				color:white;
				font-size:20px;
				border:none;
				outline:none;
				border-radius:5px;
			}
		}
	 </style>
  </head>
  <body>
  <% Book book=(Book) request.getAttribute("book"); %>
		<form action='http://localhost:8080/Project/BookUpdateServlet' method='get'>
			<h2>修改图书信息</h2>
			<p class='p1'>&nbsp;<input type="hidden" name='bookid' value="${ requestScope.book.bookid}"></p>
			<p>图书名字:&nbsp;<input type="text" value="${ requestScope.book.bookname}" name='bookname'></p>
			<p>图书价格:&nbsp;<input type="text" value='${ requestScope.book.price}' name='price'></p>
			<p>图书作者:&nbsp;<input type="text" value='${ requestScope.book.author}' name='authors'></p>
			<p>图书类别:&nbsp;<select name='categoryid'>
			
			 
				 <option  value="1" <c:if test="${book.getCategoryid()==1 }">selected</c:if>>小说</option>
				 <option value="2" <c:if test="${book.getCategoryid()==2 }"> selected</c:if>>散文</option>
				 <option value="3" <c:if test="${book.getCategoryid()==3 }">selected</c:if> >历史</option>
				  <option value="4" <c:if test="${book.getCategoryid()==3 }"> selected</c:if>>传记</option>
				  <option value="5" <c:if test="${book.getCategoryid()==3 }"> selected</c:if>>哲学</option>
	
			</select>
			</p>
				<p><input type="submit" value="修改" class="btn"></p>
	    </form>
	    <script>
        // 检查用户是否已登录
        var userLoggedIn = <%= session.getAttribute("user") != null %>;

        // 如果用户未登录，则跳转到登录页面
        if (!userLoggedIn) {
            window.location.href = "/Project/login.jsp";
        }
    </script>
 </body>
</html>