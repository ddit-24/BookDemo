package com.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JdbcUtils {
	//私有静态类型
    private static Properties ps = new Properties();
    static{
    	 //通过io流
        InputStream is = JdbcUtils.class.getResourceAsStream("/jdbc.properties");
        //
        try {
			ps.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static Connection getconn(){
    	Connection conn =null;
    	try {
			Class.forName(ps.getProperty("dirver"));
			conn = DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("username"),ps.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
    }
    //封装释放资源
    public static void close(Connection coon,PreparedStatement pre,ResultSet rs){
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(pre!=null){
    		try {
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(coon!=null){
    		try {
				coon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
   
}
