package com.ServiceImpl;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.User;
import com.Service.UserService;

public class UserServiceImpl implements UserService {

	public int useradd(User user) {
		//ע��ҵ���ж��û����Ƿ����
		UserDao userDao = new UserDaoImpl();
		User u =userDao.selectUserName(user);
		if(u==null){
			//����û�
			userDao.useradd(user);
		}
		else{
			System.out.println("�û����Ѵ���");
		}
		return 0;
	}
}
