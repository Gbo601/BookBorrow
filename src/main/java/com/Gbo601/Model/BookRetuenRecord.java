package com.Gbo601.Model;

import java.sql.Date;

/**
 * @author Gbo601
 * @create 2021-05-14 10:18
 */
public class BookRetuenRecord {
    private String id;
    private String userID;
    private String book_id;
    private Date borrowTime;
    private Date returnTime;

    public BookRetuenRecord(String id, String userID, String book_id, Date borrowTime, Date returnTime) {
        this.id = id;
        this.userID = userID;
        this.book_id = book_id;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }

    public BookRetuenRecord() {
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
}
