package com.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.User;

public class UserTest {
	public static void main(String[] args) {
      User user = new User();
      //相当于前端接收到的数据
      String username = "admin";
      String password = "123";
      user.setUsername(username);
      user.setPassword(password);
      //调用Dao层实现类完成查询单个用户的功能
      UserDao usd = new UserDaoImpl();
      User u = usd.selectUser(user);
      if(u==null){
    	  System.out.println("该用户不存在,跳转注册页面");
      }
      else{
    	  System.out.println("登录成功，跳转首页");
      }
      System.out.println(user+"++++++++");
	}
}
