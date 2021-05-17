package com.Gbo601.DAO.BookDAO;

import java.sql.Connection;
import java.util.List;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.Book;

/**
 * 
 * @Description
 * @author xieyunlei Email:2451983737@qq.com
 * @verson
 * @date 2021年5月14日上午10:00:35
 *
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

	@Override
	public void insert(Connection conn, Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into book()value(?,?,?,?,?,?,?)";
		update(conn, sql,book.getBook_id(),book.getBook_name(),book.getBook_author(),book.getBook_publishHouse(),book.getBook_price(),book.getBook_stock(),book.getBook_image());
		
	}

	@Override
	public void delete(Connection conn, String book_id) {
		// TODO Auto-generated method stub
		String sql = "delete from book where book_id = ?";
		update(conn, sql,book_id);
	}

	@Override
	public void update(Connection conn, Book book) {
		// TODO Auto-generated method stub
		String sql = "update book set book_id=?,book_name=?,book_author=?,book_publishHouse=?,book_price=?,book_stock=? where book_id= ?";
		update(conn,sql,book.getBook_id(),book.getBook_name(),book.getBook_author(),book.getBook_publishHouse(),book.getBook_price(),book.getBook_stock(),book.getBook_id());
	}

	@Override
	public void updateStock(Connection conn, Book book) {
		String sql="update book set book_stock=? where book_id=?";
		update(conn,sql,book.getBook_stock(),book.getBook_id());
	}

	@Override
	public int getStock(Connection conn, String book_id) {
		String sql="select book_stock from book where book_id=?";
		Book book=getInstance(conn,sql,book_id);
		return book.getBook_stock();
	}

	@Override
	public Book getBookByName(Connection conn, String book_name) {
		// TODO Auto-generated method stub
		String sql = "select book_id,book_name,book_author,book_publishHouse,book_price,book_stock from Book where book_name= ?";
		Book book = getInstance(conn, sql, book_name);
		return book;
	}
	@Override
	public List<Book> getAll(Connection conn){
		String sql="select book_id,book_name,book_author,book_publishHouse,book_price,book_stock from Book";
		List<Book> list = getForList(conn, sql);
		return list;
	}
	@Override
	public Long getCount(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Book";
		return getValue(conn, sql);
	}
	
	

}
