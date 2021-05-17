package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-14 18:22
 */
public class ModifyBookBorrowController {


    @FXML
    private Pane root;

    @FXML
    private TextField textFieldModifyBookBorrowId;

    @FXML
    private TextField textFieldModifyBookBorrowUserId;

    @FXML
    private TextField textFieldModifyBookBorrowBookId;

    @FXML
    private TextField textFieldModifyBookBorrowBorrowTime;

    @FXML
    private TextField textFieldModifyBookBorrowReturnTime;

    @FXML
    private JFXButton btnBookBorrowModifyDefine;

    @FXML
    private JFXButton btnBookBorrowModifyCancle;


    private static BookBorrow bookBorrow;
    private BookBorrowDAOIpml bookBorrowDAOIpml=new BookBorrowDAOIpml();
    private String funtion;
    private ObservableList<BookBorrow> oblist;
    private TableView<BookBorrow> BookBorrowTable;

    @FXML
    void BookBorrowModifyCancle(ActionEvent event) {
        Stage primaryStage=(Stage)btnBookBorrowModifyCancle.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    void BookBorrowModifyDefine(ActionEvent event) {
        Connection conn=null;
        List<BookBorrow> list=null;
        int i=Integer.parseInt(textFieldModifyBookBorrowId.getText());
        bookBorrow.setId(i);
        bookBorrow.setUserID(textFieldModifyBookBorrowUserId.getText());
        bookBorrow.setBook_id(textFieldModifyBookBorrowBookId.getText());
        bookBorrow.setBorrowTime(java.sql.Date.valueOf(textFieldModifyBookBorrowBorrowTime.getText()));
        bookBorrow.setBorrowTime(java.sql.Date.valueOf(textFieldModifyBookBorrowReturnTime.getText()));
        try {
            conn= JDBCUtils.getConnection();
            if(funtion.equals("addBookBorrow")){
                bookBorrowDAOIpml.insert(conn,bookBorrow);
            }else{
                bookBorrowDAOIpml.managerUpdate(conn,bookBorrow);
            }

            list=bookBorrowDAOIpml.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist= FXCollections.observableList(list);
        BookBorrowTable.setItems(oblist);
        Stage primaryStage=(Stage)btnBookBorrowModifyDefine.getScene().getWindow();
        primaryStage.hide();
    }
    void setFuntion(String funtion){
        this.funtion=funtion;
    }
    void setTableView(TableView BookBorrowTable){
        this.BookBorrowTable=BookBorrowTable;
    }
    void setUser(BookBorrow bookBorrow){
        this.bookBorrow=bookBorrow;
        textFieldModifyBookBorrowId.setText(""+bookBorrow.getId());
        textFieldModifyBookBorrowUserId.setText(bookBorrow.getUserID());
        textFieldModifyBookBorrowBookId.setText(bookBorrow.getBook_id());
        textFieldModifyBookBorrowBorrowTime.setText(bookBorrow.getBorrowTime().toString());
        textFieldModifyBookBorrowReturnTime.setText(bookBorrow.getReturnTime().toString());
    }

}
