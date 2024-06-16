package com.ServiceImpl;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.User;
import com.Service.UserService;

public class UserServiceImpl implements UserService {

	public int useradd(User user) {
		//注册业务，判断用户名是否存在
		UserDao userDao = new UserDaoImpl();
		User u =userDao.selectUserName(user);
		if(u==null){
			//添加用户
			userDao.useradd(user);
		}
		else{
			System.out.println("用户名已存在");
		}
		return 0;
	}
}
