package com.Gbo601.DAO.BookReturnRecord;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.BookReturnRecord;


import java.sql.Connection;
import java.util.List;

public class BookReturnRecordDAOImpl extends BaseDAO<BookReturnRecord> implements BookReturnRecordDAO{

	@Override
	public void insert(Connection conn, BookReturnRecord bookReturnRecord) {
		// TODO Auto-generated method stub
		String sql = "insert into book_returnrecord()values(?,?,?,?,?)";
		update(conn,sql, bookReturnRecord.getId(),bookReturnRecord.getUserID(),bookReturnRecord.getBook_id(),bookReturnRecord.getBorrowTime(),bookReturnRecord.getReturnTime());;
	}

	@Override
	public void delete(Connection conn, BookReturnRecord id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, BookReturnRecord bookReturnRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookReturnRecord getBookReturnRecordUerID(Connection conn, BookReturnRecord id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookReturnRecord> getAll(Connection conn) {
		return null;
	}

	@Override
	public Long getCount(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
