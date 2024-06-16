package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.CategoryDao;
import com.Entity.Category;
import com.Entity.User;
import com.Utils.JdbcUtils;

public class CategoryDaolmpl implements CategoryDao {

    @Override
    public List<Category> selectList() {
        // TODO Auto-generated method stub
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement ps=null;
        Category category=null;
        List<Category> categories= new ArrayList<Category>();
        try {
            conn=JdbcUtils.getconn();
             ps =conn.prepareStatement("SELECT * FROM category ");
            rs = ps.executeQuery();
            while(rs.next()){
                int categoryid = rs.getInt("categoryid");
                String categoryname = rs.getString("categoryname");
                category=new Category(categoryid,categoryname);
                categories.add(category);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(conn, ps, rs);
        }    
        return categories;
    }	
    

}