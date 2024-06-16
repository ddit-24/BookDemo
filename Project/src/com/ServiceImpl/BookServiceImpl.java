package com.ServiceImpl;

import java.util.List;

import com.Dao.BookDao;
import com.DaoImpl.BookDaoImpl;
import com.Entity.Book;
import com.Service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public boolean BookAdd(Book book) {
		//������ӷ���
		BookDao bd = new BookDaoImpl();
		//����Dao���ѯ���������ж��Ƿ����
		Book bk = bd.SelectBookName(book);
		if(bk==null){
			bd.BookAdd(book);
			return true;
		}
		else{
			System.out.println("ͼ���Ѵ���");
			return false;
		}  
	}

	@Override
	public List<Book> SelectAllBook() {
		BookDao bd = new BookDaoImpl();
		List<Book> listbook= bd.SelectAllBook();
		return listbook;
	}

	@Override
	public void DeleteBookOne(int bookid) {
		BookDao bd = new BookDaoImpl();
		bd.DeleteBookOne(bookid);
	}

	@Override
	public Book SelectById(int bookid) {
		BookDao bd = new BookDaoImpl();
		Book book= bd.SelectById(bookid);
		return book;
	}

	@Override
	public void UpdateById(Book book) {
		BookDao bd = new BookDaoImpl();
		bd.UpdateById(book);
	}
	@Override
	  public List<Book> searchBooks(String query) {
		  BookDao bd = new BookDaoImpl();
	        List<Book> booklist = bd.searchBooks(query);
	        // TODO Auto-generated method stub
	        return booklist;
	    }

}
