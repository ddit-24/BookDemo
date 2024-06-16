package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.BookDao;
import com.Entity.Book;
import com.Entity.User;
import com.Utils.JdbcUtils;

public class BookDaoImpl implements BookDao {

	public void BookAdd(Book book) {
		PreparedStatement ps =null;
		Connection conn=null;
		User u=null;

		try {
			conn = JdbcUtils.getconn();
			
			ps = conn.prepareStatement("insert into book value(null,?,?,?,?)");
		    ps.setString(1, book.getBookname());
		    ps.setDouble(2, book.getPrice());
		    ps.setString(3, book.getAuthor());
		    ps.setInt(4, book.getCategoryid());
		    int i = ps.executeUpdate();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		JdbcUtils.close(conn, ps, null);
		
	}

	@Override
	public Book SelectBookName(Book book) {
		ResultSet rs =null;
		PreparedStatement ps =null;
		Connection conn=null;
		Book b=null;
		try {
			conn = JdbcUtils.getconn();
			ps = conn.prepareStatement("select * from book where bookname=?");
		    ps.setString(1, book.getBookname());
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	int id = rs.getInt("bookid");
		    	String bookname = rs.getString("bookname");
		    	double price = rs.getDouble("price");
		    	String author = rs.getString("authors");
		    	int categoryid =rs.getInt("categoryid");
		    	 b = new Book(id,bookname,price,author,categoryid);
		    	
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtils.close(conn, ps, rs);
		}
		return b;
	}

	@Override
	public List<Book> SelectAllBook() {
		ResultSet rs =null;
		PreparedStatement ps =null;
		Connection conn=null;
		Book b=null;
		List<Book> listbook = new ArrayList<>();
		try {
			conn = JdbcUtils.getconn();
            ps=conn.prepareStatement("select b.bookid,b.bookname,b.price,b.authors,bc.categoryname,b.categoryid from book as  b left join category as bc on b.categoryid=bc.categoryid");
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	int id = rs.getInt("b.bookid");
		    	String bookname = rs.getString("b.bookname");
		    	double price = rs.getDouble("b.price");
		    	String author = rs.getString("b.authors");
		    	String categoryname =rs.getString("bc.categoryname");
		    	int categoryid = rs.getInt("b.categoryid");
//		int bookid, String bookname, double price, String author, int categoryid, String categoryname
		    	 b = new Book(id,bookname,price,author,categoryid,categoryname);
		    	
		    	 listbook.add(b);
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtils.close(conn, ps, rs);
		}
		return listbook;
	}
    // ɾ������ͼ��
	@Override
	public void DeleteBookOne(int bookid) {
		PreparedStatement ps =null;
		Connection conn=null;
		Book book=null;
		//�������ݿ�
		//�������ݿ�����
		try {
			conn = JdbcUtils.getconn();
			
			ps = conn.prepareStatement("delete from book where bookid=?");
		    ps.setInt(1,bookid);
		    //ִ��sql���
		    int i = ps.executeUpdate();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    System.out.println("�û�ɾ����"+i+"��");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		JdbcUtils.close(conn, ps, null);
		
		
	}

	@Override
	public Book SelectById(int bookid) {
		ResultSet rs =null;
		PreparedStatement ps =null;
		Connection conn=null;
		Book b=null;
		List<Book> listbook = new ArrayList<>();
		//�������ݿ�
		//�������ݿ�����
		try {
			conn = JdbcUtils.getconn();
            ps=conn.prepareStatement("select * from book where bookid=?");
            ps.setInt(1,bookid);
		    //ִ��sql���
		    rs = ps.executeQuery();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    while(rs.next()){
		    	int id = rs.getInt("bookid");
		    	String bookname = rs.getString("bookname");
		    	double price = rs.getDouble("price");
		    	String author = rs.getString("authors");
		    	String stringcategoryid =rs.getString("categoryid");
		    	int categoryid = Integer.parseInt(stringcategoryid);
		    	 b = new Book(id,bookname,price,author,categoryid);
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtils.close(conn, ps, rs);
		}
		return b;
	}

	@Override
	public void UpdateById(Book book) {
		PreparedStatement ps =null;
		Connection conn=null;
		//Book book=null;
		//�������ݿ�
		//�������ݿ�����
		try {
			conn = JdbcUtils.getconn();
			
			ps = conn.prepareStatement("update book b set b.bookname=?,b.price=?,b.categoryid=?,b.authors=? where b.bookid=?");
		    ps.setString(1, book.getBookname());
		    ps.setDouble(2,book.getPrice());
		    ps.setInt(3,book.getCategoryid());
		    ps.setString(4,book.getAuthor());
		    ps.setInt(5, book.getBookid());
		    //ִ��sql���
		    int i = ps.executeUpdate();
		    //�����ѯ�������ݻ�ȫ���ŵ�requsetset���棬��Ҫ�ó���
		    System.out.println("�û�������"+i+"��");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		JdbcUtils.close(conn, ps, null);
	}
	public List<Book> searchBooks(String query) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT bookid,bookname,price,authors,categoryname FROM book b left join category c on b.categoryid=c.categoryid WHERE bookname LIKE ? or authors LIKE ?";
        PreparedStatement ps = null;
        Connection conn= null;
        ResultSet rs=null;
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn =JdbcUtils.getconn();
             ps = conn.prepareStatement(sql);
             ps .setString(1, "%" + query + "%");
             ps .setString(2, "%" + query + "%");
             rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setPrice(rs.getDouble("price"));
                book.setAuthor(rs.getString("authors"));
                book.setCategoryname(rs.getString("categoryname"));
                bookList.add(book);
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(conn, ps, rs);    
        }
        return bookList;
    }
}
