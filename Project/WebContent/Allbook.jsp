<%@ page import="com.Entity.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.Entity.Book" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>首页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html, body {
            width: 100%;
            height: 100%;
            background: linear-gradient(to top right, #ffb2b2, #ffeac5, #89cfff, #9affe3);
        }
        span {
            display: block;
            margin: 28px 0 0 140px;
            color: blue;
            .image{
               display:inline-block;
               width:26px;
               height:26px;
               position:absolute;
               top:26px;
               left:221px;
            }
            
        }
        .search-form {
            display: inline-block;
            margin: 20px 0 0 140px;
            width: 320px;
            height: 50px;
            .input {
	            width: 258px;
	            height: 38px;
	            border: none;
	            outline: none;
	            border-radius: 5px 0 0 5px;
	            opacity: 0.6;
	         }
	         .findbtn {
	            width: 55px;
	            height: 38px;
	            margin-left: -5px;
	            border-radius: 0 5px 5px 0;
	            border: none;
	            background: #87f193;
	        }
        }
         
        
        .no-results {
            width: 300px;
            height: 20px;
            margin: 5px 0 0 140px;
        }
        .back-to-home {
            display: inline-block;
            width: 100px;
            height: 40px;
            margin: 0 0 0 25px;
        }
        .back-to-home .button {
            display: block;
            width: 76px;
            height: 35px;
            text-decoration: none;
            border: 1px solid #d2ffd2;
            border-radius: 5px;
            background: #def;
            font-size: 16px;
            line-height: 33px;
            text-align: center;
        }
        .addbtn {
            width: 106px;
            height: 44px;
            border: 1px solid #67C23A;
            color: #67C23A;
            font-size: 18px;
            border-radius: 9px;
            position: absolute;
            left: 82%;
            bottom: 85%;
        }
        .addbtn:hover {
            background: #67C23A;
            border: none;
            color: white;
        }
        .sellectbtn {
            width: 106px;
            height: 44px;
            border: 1px solid #E6A23C;
            color: #E6A23C;
            font-size: 18px;
            border-radius: 9px;
            position: absolute;
            left: 74%;
            bottom: 85%;
        }
        .sellectbtn:hover {
            background: #E6A23C;
            border: none;
            color: white;
        }
        table {
            width: 80%;
            border: 1px solid #409EFF;
            margin: 28px auto;
        }
        tr {
            width: 100%;
        }
        .firstth {
            width: 120px;
        }
        th {
            background: #93c9ff;
            height: 78px;
            font-size: 19px;
            font-family: '微软雅黑';
        }
        .lastth {
            width: 228px;
        }
        .firsttd {
            width: 120px;
        }
        td {
            height: 72px;
            background: #efefef;
            text-align: center;
        }
        .lasttd {
            width: 228px;
        }
        button {
            width: 86px;
            height: 44px;
            font-size: 20px;
            border-radius: 9px;
        }
        .btn1 {
            border: 1px solid #F56C6C;
            color: #F56C6C;
        }
        .btn2 {
            border: 1px solid #409EFF;
            color: #409EFF;
        }
        .btn1:hover {
            background: #F56C6C;
            border: none;
            color: white;
        }
        .btn2:hover {
            background: #409EFF;
            border: none;
            color: white;
        }
        .delallbtn {
            width: 86px;
            height: 44px;
            font-size: 18px;
            border-radius: 9px;
            width: 105px;
            height: 44px;
            border: 1px solid #F56C6C;
            color: #F56C6C;
        }
        .delallbtn:hover {
            background: #F56C6C;
            border: none;
            color: white;
        }
        #submit-button {
            display: none;
            position: absolute;
            top: 45px;
            left: 200px;
            width: 80px;
            height: 30px;
            border: 1px solid #D0D6DB;
            background-color: #D0D6DB;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        
    </style>
</head>
<body>
    <span>你好，${sessionScope.user.username }
        <img src="./我的.png" class="image">
        <a href="LoginOutServlet"><button id="submit-button">退出</button></a>
    </span>
    <form class="search-form" action="SearchBookServlet" method="get">
        <input class="input" type="text" name="query" placeholder="输入图书名称或作者">
        <input class="findbtn" type="submit" value="查询">
    </form>
    <div class="back-to-home">
        <a href="BookSelectAllServlet" class="button">返回首页</a>
    </div>
    <a href="CategorySelectAllServlet"><button class="sellectbtn">查询分类</button></a>
    <a href="bookadd.jsp"><button class="addbtn">添加图书</button></a>
    <c:if test="${empty requestScope.booklist}">
        <div class="no-results">没有找到符合条件的图书。</div>
    </c:if>
    <form action="BookDeleteAllServlet" method="post">
        <table>
            <tr>
                <th class="firstth"><input type="submit" class="delallbtn" value="批量删除"></th>
                <th>图&emsp;书&nbsp;id</th>
                <th>书&emsp;&emsp;名</th>
                <th>价&emsp;&emsp;格</th>
                <th>作&emsp;&emsp;者</th>
                <th>类&emsp;&emsp;别</th>
                <th class="lastth">操&emsp;&emsp;作</th>
            </tr>
            <c:forEach var="book" items="${requestScope.booklist}">
                <tr>
                    <td class="firsttd"><input type="checkbox" name="bookids" value="${ book.getBookid() }" /></td>
                    <td>${ book.getBookid() }</td>
                    <td>${ book.getBookname() }</td>
                    <td>${ book.getPrice() }</td>
                    <td>${ book.getAuthor() }</td>
                    <td>${ book.getCategoryname() }</td>
                    <td class="lasttd">
                        <a href='BookDeleteOneServlet?bookid=${ book.getBookid() }'><button class="btn1" type="button">删除</button></a>
                        <a href='BookSelectByIdServlet?bookid=${ book.getBookid() }'><button class="btn2" type="button">修改</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <script>
       const image= document.querySelector('.image');
       const submitbutton = document.querySelector('#submit-button');
       image.addEventListener('mouseenter',()=>{
    	  image.src='./我的-active.png';
    	  submitbutton.style.display='block';
    	  
       })
        image.addEventListener('mouseout',()=>{
        	const rectImage = image.getBoundingClientRect();
            const rectButton = submitbutton.getBoundingClientRect();
            const mouseX = event.clientX;
            const mouseY = event.clientY;

            if (
                mouseX < rectImage.left || mouseX > rectImage.right ||
                mouseY < rectImage.top || mouseY > rectImage.bottom
            ) {
                if (
                    mouseX < rectButton.left || mouseX > rectButton.right ||
                    mouseY < rectButton.top || mouseY > rectButton.bottom
                ) {
                    image.src = './我的.png';
                    submitbutton.style.display = 'none';
                }
            }
         
       })
       submitbutton.addEventListener('mouseenter',()=>{
     	   submitbutton.style.display='display';
       })
       submitbutton.addEventListener('mouseleave',()=>{
     	   submitbutton.style.display='none';
     	   image.src = './我的.png';
       })
    </script>
</body>
</html>
