package com.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Entity.User;

public class UserTest {
	public static void main(String[] args) {
      User user = new User();
      //�൱��ǰ�˽��յ�������
      String username = "admin";
      String password = "123";
      user.setUsername(username);
      user.setPassword(password);
      //����Dao��ʵ������ɲ�ѯ�����û��Ĺ���
      UserDao usd = new UserDaoImpl();
      User u = usd.selectUser(user);
      if(u==null){
    	  System.out.println("���û�������,��תע��ҳ��");
      }
      else{
    	  System.out.println("��¼�ɹ�����ת��ҳ");
      }
      System.out.println(user+"++++++++");
	}
}
