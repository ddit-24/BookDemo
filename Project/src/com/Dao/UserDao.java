package com.Dao;

import com.Entity.User;

//import java.sql.SQLException;

public interface UserDao {
   //  public void selectUser(String username,String password)
	//登录
	 public   User  selectUser(User user);
	//注册接口
	 public int useradd(User user);
	 //查询用户名
	 public User selectUserName(User user);
	 
}
