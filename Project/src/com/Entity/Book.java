package com.Entity;

public class Book {
   private int bookid;
   private String bookname;
   private double price;
   private String author;
   private int categoryid;
   private String categoryname;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	public Book(int bookid, String bookname, double price, String author, int categoryid) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.categoryid = categoryid;
	}
	
	public Book(int bookid, String bookname, double price, String author, int categoryid, String categoryname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	public Book( String bookname, double price, String author, int categoryid) {
		super();
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.categoryid = categoryid;
	}
	
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Book(int bookid, String bookname, double price, String author, String categoryname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.categoryname = categoryname;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", price=" + price + ", author=" + author
				+ ", categoryid=" + categoryid + "]";
	}
   
}
