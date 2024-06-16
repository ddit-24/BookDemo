<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        html,body{
            height:100%;
            position:relative;
        }
        .father{
            width:749px;
            height:475px;
            border:1px solid gray;
            position:absolute;
            left:50%;
            top:50%;
            transform:translate(-50%,-50%);
            border-radius:25px;
        }
        .son{
            width:50%;
            height:100%;
            position:absolute;
            left:50%;
            background:#20b2aa;
            border-radius:25px;
            float:left;
            color:white;
            display:flex;
            justify-content:center;
            align-items:center;
            .center{
                width:310px;
                height:90px;
                h3{
                    text-align:center;
                    margin-bottom:6px;
                }
                a{
                    text-decoration: none;
                    color:white;
                    border:1px solid white;
                    border-radius:5px;
                    display:block;
                    width:60px;
                    height:30px;
                    line-height:30px;
                    margin-left:114px;
                    text-align:center;
                    margin-top:6px;
                }
            }
        }
        .left{
            width:50%;
            right:100%;
            border-radius:25px;
            float:left;
            box-sizing:border-box;
            h1{
               text-align:center;
               margin:60px 0 0 0;
               box-sizing:border-box;
            }
            form{
                width:70%;
                height:210px;
               
                margin:36px 0 0 55px;
                p{
                    font-size:16px;
                    margin:5px;

                }
                input{
                    width:250px;
                    height:30px;
                    outline-color:#fac06c;
                    border:1px solid gray;
                    margin:5px 0 5px 0;
                    border-radius:5px;
                    
                }
                .code{
                    width:130px;
                    height:30px;
                    outline-color:#fac06c;
                    border:1px solid gray;
                    margin:5px 0 5px 0;
                    border-radius:5px;
                }
                
                button{
                    width:63px;
                    height:33px;
                    font-size:18px;
                    color:white;
                    background:red;
                    outline:none;
                    border:1px solid #ede0e0;
                    margin:30px 0 0 92px;
                    border-radius:5px;
                }
            }
        }
        img{
          display:inline-block;
          width:110px;
          height:32px;
          margin:-13px 0 0 10px;
          position:absolute;
          top:300px;
          left:187px;
        }
        
    </style>
</head>
<body>
    <div class="father">
       <div class="left">
            <h1>用户登录</h1>
            <form action="login" method="post">
               <p>用户名<span style="color:red">*</span><br><input type="text" name="username" placeholder="请输入用户名"></p>
               <p>密码<span style="color:red">*</span><br><input type="password" name="password" placeholder="请输入密码"></p>
               <p>验证码<span style="color:red">*</span><br><input type="text" name="code" class="code"><img src="http://localhost:8080/Project/CodeServlet">
               </p>
               
               <button>登录</button> 
            </form>
       </div>
        <div class="son">
            <div class="center">
                <h3>没有账号？</h3>
                <p>立即注册加入我们吧,和我们一起开启旅程吧</p>
                <a href="register.jsp">注册</a>
            </div>
        </div>
    </div>
</body>
</html>