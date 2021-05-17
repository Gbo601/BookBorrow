package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialogLayout;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-15 10:21
 */
public class BookBorrowSelectTimeController {
    @FXML
    private JFXButton btnBookBorrowDefine;

    @FXML
    private JFXButton btnBookBorrowCancle;

    @FXML
    private JFXDatePicker ReturnTime;

    private static BookBorrow bookBorrow;
    private static Book book;
    private BookBorrowDAOIpml bookBorrowDAOIpml=new BookBorrowDAOIpml();
    private BookDAOImpl bookDAO=new BookDAOImpl();
    private ObservableList<Book> oblist;
    private ObservableList<BookBorrow> oblist1;
    private TableView<Book> BookTable;
    private TableView<BookBorrow> BookBorrowTable;
    private  static  String funtion="1";
    private  User user;
    @FXML
    void BookBorrowCancle(ActionEvent event) {
        Stage primaryStage=(Stage)btnBookBorrowCancle.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    void BookBorrowDefine(ActionEvent event) {
        Connection conn=null;
        String dateEnd=ReturnTime.getValue().toString();
        List<Book> listBook=null;
        List<BookBorrow> listBookBorrow=null;

        bookBorrow.setBorrowTime(new java.sql.Date(System.currentTimeMillis()));
        bookBorrow.setReturnTime(java.sql.Date.valueOf(dateEnd));

        try {
            conn= JDBCUtils.getConnection();
            if(funtion.equals("Renew")){
                bookBorrowDAOIpml.userRenewUpdate(conn,bookBorrow);
                listBookBorrow=bookBorrowDAOIpml.getPersonAll(conn,user);
            }else{
                int stock=bookDAO.getStock(conn,book.getBook_id())-1;
                book.setBook_stock(stock);
                bookDAO.updateStock(conn,book);
                bookBorrowDAOIpml.insert(conn,bookBorrow);
                listBook=bookDAO.getAll(conn);
            }
        } catch (Exception e) {
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(funtion.equals("Renew")){
            oblist1= FXCollections.observableList(listBookBorrow);
            BookBorrowTable.setItems(oblist1);
        }else{
            oblist= FXCollections.observableList(listBook);
            BookTable.setItems(oblist);
        }
        Stage primaryStage=(Stage)btnBookBorrowDefine.getScene().getWindow();
        primaryStage.hide();
    }
    void setUser(BookBorrow bookBorrow){
        this.bookBorrow=bookBorrow;
    }
    void setBook(Book book){
        this.book=book;
    }
    void setTable(TableView BookTable){
        this.BookTable=BookTable;
    }
    void setBookBorrowTable(TableView BookBorrowTable){
        this.BookBorrowTable=BookBorrowTable;
    }
    void setFuntion(String funtion){
        this.funtion=funtion;
    }
    void setuserUser(User user){
        this.user=user;
    }
    //    设置弹窗
    public void showDialog(String Heading,String Body){
        JFXAlert alert = new JFXAlert((Stage) btnBookBorrowDefine.getScene().getWindow());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setOverlayClose(false);

        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Label(Heading));
        layout.setBody(new Label(Body));

        JFXButton closeButton = new JFXButton("好的");
        closeButton.getStyleClass().add("dialog-accept");
        closeButton.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(closeButton);
        alert.setContent(layout);
        alert.show();
    }

}
