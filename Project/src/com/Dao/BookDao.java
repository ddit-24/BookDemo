package com.Dao;

import java.util.List;

import com.Entity.Book;

public interface BookDao {
     //�����
	//���ͼ��
	public void BookAdd(Book book);
	//��ѯ����
	public Book SelectBookName(Book book);
	//��ȫ����
	public List<Book> SelectAllBook();
	//ɾ������ͼ��
	public void DeleteBookOne(int bookid);
	//��ѯ��������
	public Book SelectById(int bookid);
	//�޸�����
	public void UpdateById(Book book);
	//��ѯͼ��
	public List<Book> searchBooks(String query);
}
