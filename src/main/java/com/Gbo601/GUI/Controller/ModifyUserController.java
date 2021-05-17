package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-13 20:42
 */
public class ModifyUserController {
    private static User user;
    private UserDAOImpl userDAO=new UserDAOImpl();
    private String funtion;

    @FXML
    private TextField textFieldModifyUserID;

    @FXML
    private TextField textFieldModifyUserPassword;

    @FXML
    private TextField textFieldModifyUserEmail;

    @FXML
    private TextField textFieldModifyUserIdentity;

    @FXML
    private TextField textFieldModifyUserPhone;

    @FXML
    private TextField textFieldModifyUserName;

    @FXML
    private TextField textFieldModifyUserAge;

    @FXML
    private TextField textFieldModifyUserSex;

    @FXML
    private JFXButton btnModifyDefine;

    @FXML
    private JFXButton btnModifyCancle;

    private ObservableList<User> oblist;
    private TableView<User> userUserTable;


    @FXML
    void ModifyCancle(ActionEvent event) {
        Stage primaryStage=(Stage)btnModifyCancle.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    void ModifyDefine(ActionEvent event) {
        Connection conn=null;
        List<User> list=null;
        user.setUserID(textFieldModifyUserID.getText());
        user.setUserPassword(textFieldModifyUserPassword.getText());
        int i=Integer.parseInt(textFieldModifyUserIdentity.getText());
        user.setIdentity(i);
        user.setUserName(textFieldModifyUserName.getText());
        user.setUserAge(textFieldModifyUserAge.getText());
        user.setUserSex(textFieldModifyUserSex.getText());
        user.setUserEmail(textFieldModifyUserEmail.getText());
        user.setUserPhone(textFieldModifyUserPhone.getText());
        try {
            conn= JDBCUtils.getConnection();
            if(funtion.equals("addUser")){
                userDAO.insert(conn,user);
            }else{
                userDAO.managerUpdate(conn,user);
            }

            list=userDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist= FXCollections.observableList(list);
        userUserTable.setItems(oblist);
        Stage primaryStage=(Stage)btnModifyDefine.getScene().getWindow();
        primaryStage.hide();
    }
    void setFuntion(String funtion){
        this.funtion=funtion;
    }
    void setTableView(TableView userUserTable){
        this.userUserTable=userUserTable;
    }
    void setUser(User user){
        this.user=user;
        textFieldModifyUserID.setText(user.getUserID());
        textFieldModifyUserPassword.setText(user.getUserPassword());
        textFieldModifyUserIdentity.setText(""+user.getIdentity());
        textFieldModifyUserName.setText(user.getUserName());
        textFieldModifyUserAge.setText(user.getUserAge());
        textFieldModifyUserSex.setText(user.getUserSex());
        textFieldModifyUserEmail.setText(user.getUserEmail());
        textFieldModifyUserPhone.setText(user.getUserPhone());
    }

}
