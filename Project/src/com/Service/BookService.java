package com.Service;

import java.util.List;

import com.Entity.Book;

public interface BookService {
	//添加
    public boolean BookAdd(Book book);
    //查询全部图书
	public List<Book> SelectAllBook();
	//删除单个图书
	public void DeleteBookOne(int bookid);
	//查询单个数据
	public Book SelectById(int bookid);
	//修改数据
	public void UpdateById(Book book);
	//查询
	public List<Book> searchBooks(String query);
}
