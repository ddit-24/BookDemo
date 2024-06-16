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
		//操作数据库
		//加载数据库驱动
		try {
			//调用工具类
			conn = JdbcUtils.getconn();
			ps = conn.prepareStatement("select * from User where username=? and password=?");
		    ps.setString(1, user.getUsername());
		    ps.setString(2, user.getPassword());
		    //执行sql语句
		    rs = ps.executeQuery();
		    //处理查询到的数据会全部放到requsetset里面，需要拿出来
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
		//调用工具类的释放资源
		JdbcUtils.close(conn, ps, rs);
		return u;
	}

	public int useradd(User user) {
		PreparedStatement ps =null;
		Connection conn=null;
		User u=null;
		int i=0;
		//操作数据库
		//加载数据库驱动
		try {
			conn = JdbcUtils.getconn();
			
			ps = conn.prepareStatement("insert into user value(null,?,?)");
		    ps.setString(1, user.getUsername());
		    ps.setString(2, user.getPassword());
		    //执行sql语句
		     i = ps.executeUpdate();
		    //处理查询到的数据会全部放到requsetset里面，需要拿出来
		    System.out.println("用户添加了"+i+"条");
		    
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
		//操作数据库
		//加载数据库驱动
		try {
			conn = JdbcUtils.getconn();
			ps = conn.prepareStatement("select * from User where username=?");
		    ps.setString(1, user.getUsername());
		    //执行sql语句
		    rs = ps.executeQuery();
		    //处理查询到的数据会全部放到requsetset里面，需要拿出来
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
