package com.Service;

import java.util.List;

import com.Entity.Book;

public interface BookService {
	//���
    public boolean BookAdd(Book book);
    //��ѯȫ��ͼ��
	public List<Book> SelectAllBook();
	//ɾ������ͼ��
	public void DeleteBookOne(int bookid);
	//��ѯ��������
	public Book SelectById(int bookid);
	//�޸�����
	public void UpdateById(Book book);
	//��ѯ
	public List<Book> searchBooks(String query);
}
