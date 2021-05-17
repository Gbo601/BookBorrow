package com.Gbo601.Model;

import java.sql.Date;
import java.sql.*;
public class BookReturnRecord {
	private String id;// 记录的id
	private String userID;//使用者的id
	private String book_id;
	private Date borrowTime;
	private Date returnTime;
	
	public BookReturnRecord() {
		
	}

	public BookReturnRecord(String id, String userID, String book_id, Date borrowTime, Date returnTime) {
		super();
		this.id = id;
		this.userID = userID;
		this.book_id = book_id;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	@Override
	public String toString() {
		return "BookReturnRecord [id=" + id + ", userID=" + userID + ", book_id=" + book_id + ", borrowTime="
				+ borrowTime + ", returnTime=" + returnTime + ", getId()=" + getId() + ", getUserID()=" + getUserID()
				+ ", getBook_id()=" + getBook_id() + ", getBorrowTime()=" + getBorrowTime() + ", getReturnTime()="
				+ getReturnTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
