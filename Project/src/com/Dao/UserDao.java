package com.Dao;

import com.Entity.User;

//import java.sql.SQLException;

public interface UserDao {
   //  public void selectUser(String username,String password)
	//��¼
	 public   User  selectUser(User user);
	//ע��ӿ�
	 public int useradd(User user);
	 //��ѯ�û���
	 public User selectUserName(User user);
	 
}
