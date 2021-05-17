package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

/**
 * @author Gbo601
 * @create 2021-05-12 19:42
 */
public class ModifyInfoController {

    private static User user;
    private UserDAOImpl userDAO=new UserDAOImpl();

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldSex;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private JFXButton btnDefine;

    @FXML
    private JFXButton btnCancel;

    @FXML
    void Cancel(ActionEvent event) {
        Stage primaryStage=(Stage)btnCancel.getScene().getWindow();
        primaryStage.close();
    }
    @FXML
    void Define(ActionEvent event) {
        Connection conn=null;
        try {
            conn= JDBCUtils.getConnection();
            user.setUserName(textFieldName.getText());
            user.setUserAge(textFieldAge.getText());
            user.setUserSex(textFieldSex.getText());
            user.setUserEmail(textFieldEmail.getText());
            user.setUserPhone(textFieldPhone.getText());
            userDAO.modifyInfo(conn,user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        Stage primaryStage=(Stage)btnCancel.getScene().getWindow();
        primaryStage.hide();
        ManagerMenuController controller=new ManagerMenuController();
        controller.setUser(user);
    }

    void setUser(User User){
        user=User;
        textFieldName.setText(user.getUserName());
        textFieldAge.setText(user.getUserAge());
        textFieldSex.setText(user.getUserSex());
        textFieldEmail.setText(user.getUserEmail());
        textFieldPhone.setText(user.getUserPhone());
    }
}
