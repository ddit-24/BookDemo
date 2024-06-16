package com.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dao.UserDao;
import com.Entity.User;
import com.Utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	public User selectUser(User user)  {
		ResultSet rs =null;
		PreparedStatement ps =null;
		Connection conn=null;
		User u=null;
		//�������ݿ�
		//�������ݿ�����
		try {
			//���ù�����
			conn = JdbcUtils.getconn();
			ps = conn.prepareStatement("select * from User where username=? and password=?");
		    ps.setString(1, user.getUsername());
		    ps.setString(2, user.getPassword());
		    //ִ��sql���
		    rs = ps.executeQuery();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    while(rs.next()){
		    	int id = rs.getInt("id");
		    	String username = rs.getString("username");
		    	String password = rs.getString("password");
		    	 u = new User(id,username,password);
		    	
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//���ù�������ͷ���Դ
		JdbcUtils.close(conn, ps, rs);
		return u;
	}

	public int useradd(User user) {
		PreparedStatement ps =null;
		Connection conn=null;
		User u=null;
		int i=0;
		//�������ݿ�
		//�������ݿ�����
		try {
			conn = JdbcUtils.getconn();
			
			ps = conn.prepareStatement("insert into user value(null,?,?)");
		    ps.setString(1, user.getUsername());
		    ps.setString(2, user.getPassword());
		    //ִ��sql���
		     i = ps.executeUpdate();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    System.out.println("�û������"+i+"��");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		JdbcUtils.close(conn, ps, null);
		return i;
	}

	@Override
	public User selectUserName(User user) {
		ResultSet rs =null;
		PreparedStatement ps =null;
		Connection conn=null;
		User u=null;
		//�������ݿ�
		//�������ݿ�����
		try {
			conn = JdbcUtils.getconn();
			ps = conn.prepareStatement("select * from User where username=?");
		    ps.setString(1, user.getUsername());
		    //ִ��sql���
		    rs = ps.executeQuery();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    while(rs.next()){
		    	int id = rs.getInt("id");
		    	String username = rs.getString("username");
		    	String password = rs.getString("password");
		    	 u = new User(id,username,password);
		    	
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		JdbcUtils.close(conn, ps, rs);
		
		return u;

	}

	
	
}
