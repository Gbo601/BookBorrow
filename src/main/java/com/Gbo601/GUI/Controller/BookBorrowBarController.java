package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.GUI.MyListener;
import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Util.JDBCUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;

/**
 * @author Gbo601
 * @create 2021-05-21 20:56
 */
public class BookBorrowBarController {

    @FXML
    private Label lblBorrowBookName;

    @FXML
    private Label lblBorrowBookBorrowTime;

    @FXML
    private Label lblBorrowBookReturnTime;

    private BookBorrow bookBorrow;
    private MyListener myListener;
    private BookDAOImpl bookDAO=new BookDAOImpl();
    @FXML
    void click(MouseEvent event) {
        myListener.onCLickListenerBorrow(bookBorrow);
    }
    public void setData(BookBorrow bookBorrow,MyListener myListener){
        this.bookBorrow=bookBorrow;
        this.myListener=myListener;
        Book book=null;
        Connection conn=null;
        try {
            conn= JDBCUtils.getConnection();
            book=bookDAO.getBookById(conn,bookBorrow.getBook_id());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        lblBorrowBookName.setText(book.getBook_name());
        lblBorrowBookBorrowTime.setText(bookBorrow.getBorrowTime().toString());
        lblBorrowBookReturnTime.setText(bookBorrow.getReturnTime().toString());
    }
}
