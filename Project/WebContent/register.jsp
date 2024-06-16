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
            float:left;
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
                p{
                    text-align:center;
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
        .right{
            width:50%;
            right:100%;
            position:absolute;
            left:50%;
            border-radius:25px;
            float:left;
            box-sizing:border-box;
            h1{
               text-align:center;
               margin:78px 0 0 0;
               box-sizing:border-box;
            }
            form{
                width:276px;
                height:210px;
               
                margin:34px 0 0 55px;
                p{
                    font-size:16px;
                    margin:5px 0 0 0;

                }
                input{
                    width:276px;
                    height:36px;
                    outline:none;
                    border:1px solid gray;
                    margin:5px 0 16px 0;
                    border-radius:5px;
                    padding-left:5px;
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
    </style>
</head>
<body>
    <div class="father">
       <div class="right">
            <h1>注册新用户</h1>
            <form action="register" method="post" class="list">
               <p><input type="text" name="username" placeholder="请输入用户名"></p>
               <p><input type="password" name="password" placeholder="请输入密码" class="password"></p>
               <p><input type="password" name="password" placeholder="请再次输入密码" class="repassword"></p>
               <button class="btn">注册</button>
            </form>
       </div>
        <div class="son">
            <div class="center">
                <h3>已有账号？</h3>
                <p>请使用你的账号进行登录</p>
                <a href="login.jsp">登录</a>
            </div>
        </div>
    </div>
     <script>
        const password =  document.querySelector('.password')
        const repassword =  document.querySelector('.repassword')
        const btn = document.querySelector('.btn')
        let flag
        repassword.addEventListener('change',()=>{
            if(repassword.value!==password.value){
                alert('两次密码不一致')
                flag=false
            }
            else{
            	flag=true
            }
            
        })
        btn.addEventListener('click',(e)=>{
        	console.log(flag)
        	if(flag===true){
               document.querySelector('.list').submit();
              
            }
            else{
                alert('请正确填写信息')
                 e.preventDefault(); // 阻止表单提交
                setTimeout(() => {
                    location.reload(); // Reload the page after a short delay
                }, 0); 
            }
        })
        
    </script>
</body>
</html>