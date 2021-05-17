package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.GUI.ManagerMenuStart;
import com.Gbo601.GUI.UserMenuStart;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 * @author Gbo601
 * @create 2021-05-10 21:13
 */
public class LoginController {

    @FXML
    private AnchorPane paneLogin;


    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField userId;

    @FXML
    private JFXPasswordField userPassword;


    private  String ID;
    private  String Password;
    private UserDAOImpl userDAO=new UserDAOImpl();


    @FXML
    void Login(ActionEvent event) throws IOException {
        this.ID= userId.getText();
        this.Password=userPassword.getText();
        option();
    }


    @FXML
    void closeLogin(ActionEvent event) {
        System.exit(0);
    }
    //        错误提示
    public void option() throws IOException {
        if (ID.equals("")) {
            showDialog("提示","账号不能为空");
        } else if (Password.equals("")) {
            showDialog("提示","密码不能为空");
        } else {
//            连接数据库验证密码
            boolean verification=false;
            int verificationIdentity=0;
            User user=null;
            Connection conn=null;
            try {
                conn= JDBCUtils.getConnection();
                verification=userDAO.verification(conn,ID,Password);
                verificationIdentity=userDAO.verificationIdentity(conn,ID);
                user= userDAO.getUserById(conn,ID);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeResource(conn,null);
            }
            if(verification){
                try {
                    if(verificationIdentity==1){
                        ManagerMenu(user);

                    }else{
                        UserMenu(user);
                        System.out.println(user.getIdentity());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                showDialog("提示","登录失败，请检查账号和密码是否正确");
            }
        }
    }
//    设置弹窗
    public void showDialog(String Heading,String Body){
        JFXAlert alert = new JFXAlert((Stage) btnLogin.getScene().getWindow());
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
    /**
    * @Description: 打开用户窗口
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-7 8:04
    */
    public void UserMenu(User user) throws Exception {
//        将登录按钮与场景，窗口绑定以执行关闭登录窗口
        Stage primaryStage=(Stage)btnLogin.getScene().getWindow();
        primaryStage.hide();
        UserMenuController controller=new UserMenuController();
        controller.setUser(user);
        controller.setUserId();

        UserMenuStart userMenuStart=new UserMenuStart();
        Stage stage=new Stage();
        userMenuStart.start(stage);
    }
    /**
    * @Description: 打开管理员窗口
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-7 8:43
    */
    public void ManagerMenu(User user) throws Exception{


        Stage primaryStage=(Stage)btnLogin.getScene().getWindow();
        primaryStage.hide();
        ManagerMenuController controller=new ManagerMenuController();
        controller.setUser(user);
        controller.setUserId();
        ManagerMenuStart managerMenuStart=new ManagerMenuStart();
        Stage stage=new Stage();
        managerMenuStart.start(stage);

    }
}
