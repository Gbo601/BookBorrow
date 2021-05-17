package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.Model.Book;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-14 21:05
 */
public class ModifyBookController {

    @FXML
    private TextField textFieldModifyBookId;

    @FXML
    private TextField textFieldModifyBookName;

    @FXML
    private TextField textFieldModifyBookAuthor;

    @FXML
    private JFXButton btnModifyBookDefine;

    @FXML
    private JFXButton btnModifyBookCancle;

    @FXML
    private TextField textFieldModifyBookPublishHouse;

    @FXML
    private TextField textFieldModifyBookPrice;

    @FXML
    private TextField textFieldModifyBookStock;

    @FXML
    private TextField textFieldModifyBookImage;

    private ObservableList<Book> oblist;
    private TableView<Book> BookTable;
    private static Book book;
    private BookDAOImpl bookDAO=new BookDAOImpl();
    private String funtion;

    @FXML
    void ModifyBookCancle(ActionEvent event) {
        Stage primaryStage=(Stage)btnModifyBookCancle.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    void ModifyBookDefine(ActionEvent event) {
        Connection conn=null;
        List<Book> list=null;
        book.setBook_id(textFieldModifyBookId.getText());
        book.setBook_name(textFieldModifyBookName.getText());
        book.setBook_author(textFieldModifyBookAuthor.getText());
        book.setBook_publishHouse(textFieldModifyBookPublishHouse.getText());

        float i=Float.parseFloat(textFieldModifyBookPrice.getText());
        book.setBook_price(i);

        int j=Integer.parseInt(textFieldModifyBookStock.getText());
        book.setBook_stock(j);

        book.setBook_image(null);
        try {
            conn= JDBCUtils.getConnection();
            if(funtion.equals("addBook")){
                bookDAO.insert(conn,book);
            }else{
                bookDAO.update(conn,book);
            }
            list=bookDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist= FXCollections.observableList(list);
        BookTable.setItems(oblist);
        Stage primaryStage=(Stage)btnModifyBookDefine.getScene().getWindow();
        primaryStage.hide();
    }
    void setFuntion(String funtion){
        this.funtion=funtion;
    }
    void setTableView(TableView BookTable){
        this.BookTable=BookTable;
    }
    void setUser(Book book){
        this.book=book;
        textFieldModifyBookId.setText(book.getBook_id());
        textFieldModifyBookName.setText(book.getBook_name());
        textFieldModifyBookAuthor.setText(book.getBook_author());
        textFieldModifyBookPublishHouse.setText(book.getBook_publishHouse());
        textFieldModifyBookPrice.setText(""+book.getBook_price());
        textFieldModifyBookStock.setText(""+book.getBook_stock());
        textFieldModifyBookImage.setText("");
    }
}
