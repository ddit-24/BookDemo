<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    
    
        html,body{
           height:100vh;
           background:url('./bookaddbg.png') ;
            background-size: cover;
          margin: 0; /* 去除 body 的默认边距 */
    padding: 0;
        }
        form{
           position:absolute;
           left:50%;
           top:50%;
           transform:translate(-50%,-50%);
           width:428px;
           height:370px;
           border:1px solid #d6c9c9;
           
           /* border-radius:32px; */
           /* box-shadow: 0 0 34px #CDD0D6; */
           h2{
            text-align:center;
           }
           p{
            height:40px;
            margin-left:42px;
            input{
                width:260px;
                height:30px;
                opacity:0.5;
            }
            select{
                width:267px;
                height:37px;
                opacity:0.5;
            }
           }
           .btn{
               margin-left:42px;
               width:345px;
               height:30px;
               background:#65cef1;
               color:white;
               font-size:20px;
               border:none;
               outline:none;
               border-radius:5px;
           }
        }
        .btn{
            width:106px;
            height:44px;
		    border:1px solid #67C23A;
		    color:#67C23A;
           
		     font-size:20px;
		    border-radius:9px;
		}
		.btn:hover{
		     background:#409EFF;
		     border:none;
		     color:white;
		}
    </style>
</head>
<body>
    
    <form action="BookAddServlet" method="post">
        <h2>添加图书</h2>
        <p>图书名字：<input type="text" name="bookname"/></p>
        <p>图书价格：<input type="text"  name="price"/></p>
        <p>图书作者：<input type="text"  name="authors"/></p>
        <p>图书类别：<select name="categoryid">
                <option value="1">小说</option>
                <option value="2">散文</option>
                <option value="3">历史</option>
                <option value="4">传记</option>
                 <option value="5">哲学</option>
            </select>
        </p>
        <input type="submit" value="添加" class="btn"></input>
       
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