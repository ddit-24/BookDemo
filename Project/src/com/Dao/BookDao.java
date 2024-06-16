package com.Dao;

import java.util.List;

import com.Entity.Book;

public interface BookDao {
     //解耦合
	//添加图书
	public void BookAdd(Book book);
	//查询书名
	public Book SelectBookName(Book book);
	//查全部书
	public List<Book> SelectAllBook();
	//删除单个图书
	public void DeleteBookOne(int bookid);
	//查询单个数据
	public Book SelectById(int bookid);
	//修改数据
	public void UpdateById(Book book);
	//查询图书
	public List<Book> searchBooks(String query);
}
