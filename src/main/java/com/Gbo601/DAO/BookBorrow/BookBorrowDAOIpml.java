package com.Gbo601.DAO.BookBorrow;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Model.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-14 10:20
 */
public class BookBorrowDAOIpml extends BaseDAO<BookBorrow> implements BookBorrowDAO {
    @Override
    public void insert(Connection conn, BookBorrow bookBorrow) {
        String sql="insert into book_borrow(userID,book_id,borrowTime,returnTime)values(?,?,?,?)";
        update(conn,sql,bookBorrow.getUserID(),bookBorrow.getBook_id(),bookBorrow.getBorrowTime(),bookBorrow.getReturnTime());
    }

    @Override
    public void delete(Connection conn, int id) {
        String sql="delete from book_borrow where id=?";
        update(conn,sql,id);

    }

    @Override
    public void managerUpdate(Connection conn, BookBorrow bookBorrow) {
        String sql="update book_borrow set id=?,userID=?,book_id=?,borrowTime=?,returnTime=?where id=?";
        update(conn,sql,bookBorrow.getId(),bookBorrow.getUserID(),bookBorrow.getBook_id(),bookBorrow.getBorrowTime(),bookBorrow.getReturnTime(),bookBorrow.getId());
    }

    @Override
    public void userRenewUpdate(Connection conn, BookBorrow bookBorrow) {
        String sql="update book_borrow set returnTime=? where id=?";
        update(conn,sql,bookBorrow.getReturnTime(),bookBorrow.getId());
    }

    @Override
    public BookBorrow getBookBorrowById(Connection conn, String userID) {
        String sql="select id,userID,book_id,borrowTime,returnTime from book_borrow where userID=?";
        BookBorrow bookBorrow=getInstance(conn,sql,userID);
        return bookBorrow;
    }

    @Override
    public BookBorrow getPersonBookBorrowById(Connection conn, String book_id,User user) {
        String sql="select id,userID,book_id,borrowTime,returnTime from book_borrow where book_id=? AND userID=?";
        BookBorrow bookBorrow=getInstance(conn,sql,book_id,user.getUserID());
        return bookBorrow;
    }

    @Override
    public List<BookBorrow> getAll(Connection conn) {
        String sql="select id,userID,book_id,borrowTime,returnTime from book_borrow";
        List<BookBorrow>list=getForList(conn,sql);
        return list;
    }

    @Override
    public List<BookBorrow> getPersonAll(Connection conn, User user) {
        String sql="select id,userID,book_id,borrowTime,returnTime from book_borrow where userID=?";
        List<BookBorrow> list=getForList(conn,sql,user.getUserID());
        return list;
    }
}
