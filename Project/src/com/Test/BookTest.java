package com.Test;

import com.Dao.BookDao;
import com.DaoImpl.BookDaoImpl;
import com.Entity.Book;
import com.Service.BookService;
import com.ServiceImpl.BookServiceImpl;

public class BookTest {
     public static void main(String[] args){ 
    	 Book book =new Book();
    	 book.setBookname("����");
    	 book.setPrice(30);
    	 book.setAuthor("�໪");
    	 book.setCategoryid(1);
    	 //����ҵ������ͼ�鷽��
    	 BookService bs = new BookServiceImpl();
    	 bs.BookAdd(book);
     }
}
class Deletebookone{
	public static void main(String[] args){
		BookService bs=new BookServiceImpl();
		bs.DeleteBookOne(19);
	}
}
class SelectById{
	public static void main(String[] args){ 
		BookDao bd = new BookDaoImpl();
		Book book= bd.SelectById(2);
		System.out.println(book);
	}
	
	
	
	
	
}
