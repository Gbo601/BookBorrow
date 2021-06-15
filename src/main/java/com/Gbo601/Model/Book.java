package com.Gbo601.Model;

public class Book {
	private String book_id;//书编号
	private String book_name;//书名
	private String book_author;
	private String book_publishHouse;
	private float book_price;
	private int book_stock;
	private byte[] book_image;

	public Book(String book_id, String book_name, String book_author, String book_publishHouse, float book_price, int book_stock, byte[] book_image) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_publishHouse = book_publishHouse;
		this.book_price = book_price;
		this.book_stock = book_stock;
		this.book_image = book_image;
	}

	public Book() {
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publishHouse() {
		return book_publishHouse;
	}

	public void setBook_publishHouse(String book_publishHouse) {
		this.book_publishHouse = book_publishHouse;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}

	public int getBook_stock() {
		return book_stock;
	}

	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}

	public byte[] getBook_image() {
		return book_image;
	}

	public void setBook_image(byte[] book_image) {
		this.book_image = book_image;
	}

	@Override
	public String toString() {
		return "Book{" +
				"book_id='" + book_id + '\'' +
				", book_name='" + book_name + '\'' +
				", book_author='" + book_author + '\'' +
				", book_publishHouse='" + book_publishHouse + '\'' +
				", book_price=" + book_price +
				", book_stock=" + book_stock +
				", book_image=" + book_image +
				'}';
	}
}
