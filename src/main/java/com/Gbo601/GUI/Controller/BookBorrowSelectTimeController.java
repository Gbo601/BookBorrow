package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.DAO.State.StateDAOIpml;
import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;

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
    private StateDAOIpml stateDAOIpml=new StateDAOIpml();
    private  static  String funtion="1";
    @FXML
    void BookBorrowCancle(ActionEvent event) {
        Stage primaryStage=(Stage)btnBookBorrowCancle.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    void BookBorrowDefine(ActionEvent event) {
        Connection conn=null;
        String dateEnd=ReturnTime.getValue().toString();

        bookBorrow.setBorrowTime(new java.sql.Date(System.currentTimeMillis()));
        bookBorrow.setReturnTime(java.sql.Date.valueOf(dateEnd));

        try {
            conn= JDBCUtils.getConnection();
            if(funtion.equals("Renew")){
                bookBorrowDAOIpml.userRenewUpdate(conn,bookBorrow);
            }else{
//                检测能不能借书
                if(stateDAOIpml.getNumByUserId(conn,bookBorrow.getUserID())==0){
                    showDialog("提示","您已达到最大借书次数");
                }else{
//                    库存-1
                    int stock=bookDAO.getStock(conn,book.getBook_id())-1;
                    book.setBook_stock(stock);
                    bookDAO.updateStock(conn,book);
//                    num数量减1
                    stateDAOIpml.updataBorrowNum(conn,bookBorrow.getUserID());
//                    向Borrow表中插入一条记录
                    bookBorrowDAOIpml.insert(conn,bookBorrow);
                }
            }
        } catch (Exception e) {
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        showDialog("提示","操作成功");
        Stage primaryStage=(Stage)btnBookBorrowDefine.getScene().getWindow();
        primaryStage.hide();
    }
    void setUser(BookBorrow bookBorrow){
        this.bookBorrow=bookBorrow;
    }
    void setBook(Book book){
        this.book=book;
    }
    void setFuntion(String funtion){
        this.funtion=funtion;
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
