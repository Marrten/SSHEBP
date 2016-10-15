package com.ebp.service;

import com.ebp.domain.Book;


public class CartItem {
	private Book book;
	private int num;
	private double price;
	
	public CartItem() {
		super();
	}

	public CartItem(Book book, int num, double price) {
		super();
		this.book = book;
		this.num = num;
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		this.price = book.getPrice()*this.num;
		this.price = Math.round(price * 100) / 100.0;
		return price;
	}

	
	
}
