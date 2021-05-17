package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.util.function.Function;

/**
 * @author Gbo601
 * @create 2021-05-11 8:01
 */
public class ManagerMenuController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXHamburger btnMenu;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnMins;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblText;

    @FXML
    private Pane panePersonInfo;

    @FXML
    private Pane paneUserManager;

    @FXML
    private Pane paneBookManager;

    @FXML
    private Pane paneBorrowManager;

    @FXML
    private Pane paneAbout;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane paneMenu;

    @FXML
    private VBox vbMenu;

    @FXML
    private JFXButton btnPersonInfo;

    @FXML
    private JFXButton btnDeleteStudent;

    @FXML
    private JFXButton btnUpdateStudent;

    @FXML
    private JFXButton btnInquireStudent;

    @FXML
    private JFXButton btnAbout;

    @FXML
    private JFXButton btnExit1;

    @FXML
    private JFXButton btnModifyInfo;

    @FXML
    private JFXButton btnModifyPassword;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserAge;

    @FXML
    private Label lblUserSex;

    @FXML
    private Label lblUserEmail;

    @FXML
    private Label lblUserPhone;

    @FXML
    private Label lblUserId;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnModifyUser;

    @FXML
    private Button btnDeleteUser;


    @FXML
    private Button btnSearchUser;

    @FXML
    private Button btnAddBookBorrow;

    @FXML
    private Button btnModifyBookBorrow;

    @FXML
    private Button btnDeleteBookBorrow;


    @FXML
    private Button btnBookBorrowSearch;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnModifyBook;

    @FXML
    private Button btnDeleteBook;

    @FXML
    private Button btnSearchBook;

    @FXML
    private TextField textFiledSearchUser;

    @FXML
    private TextField textFiledBookBorrowSearch;

    @FXML
    private TextField textFiledSearchBook;

    @FXML
    private TableView<User> userUserTable;

    @FXML
    private TableView<BookBorrow> BookBorrowTable;

    @FXML
    private TableView<Book> BookTable;


    @FXML
    private TableColumn<User, String> columnUserId;

    @FXML
    private TableColumn<User, String> columnUserPassword;

    @FXML
    private TableColumn<User, Integer> columnUserIdentity;

    @FXML
    private TableColumn<User, String> columnUserName;

    @FXML
    private TableColumn<User, String> columnUserAge;

    @FXML
    private TableColumn<User, String> columnUserSex;

    @FXML
    private TableColumn<User, String> columnUserEmail;

    @FXML
    private TableColumn<User, String> columnUserPhone;

    @FXML
    private TableColumn<BookBorrow, String> columnBookBorrowId;

    @FXML
    private TableColumn<BookBorrow, String> columnBookBorrowUserId;

    @FXML
    private TableColumn<BookBorrow, String> columnBookBorrowBookId;

    @FXML
    private TableColumn<BookBorrow, Date> columnBookBorrowBorrowTime;

    @FXML
    private TableColumn<BookBorrow, Date> columnBookBorrowReturnTime;

    @FXML
    private TableColumn<Book, String> columnBookId;

    @FXML
    private TableColumn<Book, String> columnBookName;

    @FXML
    private TableColumn<Book, String> columnBookAuthor;

    @FXML
    private TableColumn<Book, String> columnBookPublishHouser;

    @FXML
    private TableColumn<Book, Float> columnBookPrice;

    @FXML
    private TableColumn<Book, Integer> columnBookStock;


    private static String userId;
    private static User user;
    private final UserDAOImpl userDAO=new UserDAOImpl();
    private final BookBorrowDAOIpml bookBorrowDAO=new BookBorrowDAOIpml();
    private BookDAOImpl bookDAOImpl=new BookDAOImpl();
    ObservableList<User> oblist;
    ObservableList<BookBorrow> oblist1;
    ObservableList<Book> oblist2;



   public void setUser(User user){
       this.user=user;
   }
   public void setUserId(){
       this.userId=user.getUserID();
   }
    @FXML
    void About(ActionEvent event) {
        lblTitle.setText("关于");
        paneAbout.setVisible(true);
        paneBookManager.setVisible(false);
        paneBorrowManager.setVisible(false);
        paneUserManager.setVisible(false);
        panePersonInfo.setVisible(false);
    }


    @FXML
    void Exit(ActionEvent event) {
       System.exit(0);
    }

    @FXML
    void Exit1(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void Mins(ActionEvent event) {

    }
//     个人信息面板-修改信息
    @FXML
    void ModifyInfo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyInfo.fxml"));
            Parent root = loader.load();

            ModifyInfoController controller=loader.getController();
            controller.setUser(user);

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("修改个人信息");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//  个人信息面板-修改密码
    @FXML
    void ModifyPassword(ActionEvent event) {
       TextInputDialog dialog=new TextInputDialog();
       dialog.setTitle("修改密码");
       dialog.setContentText("请输入密码");

       Optional<String> word=dialog.showAndWait();
       if(word.isPresent()){
           String password=word.get();
           User modifyUser=new User(user.getUserID(),password,user.getIdentity(),user.getUserName(),user.getUserAge(),user.getUserSex(), user.getUserEmail(),user.getUserPhone());
           Connection conn=null;
           try {
               conn=JDBCUtils.getConnection();
               userDAO.modifyPassword(conn,modifyUser);
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               JDBCUtils.closeResource(conn,null);
           }
       }

    }


//    个人信息面板
    @FXML
    void PersonInfo(ActionEvent event) {
        lblTitle.setText("个人信息");
        paneAbout.setVisible(false);
        paneBookManager.setVisible(false);
        paneBorrowManager.setVisible(false);
        paneUserManager.setVisible(false);
        panePersonInfo.setVisible(true);

        lblUserId.setText("账号:"+user.getUserID());
        lblUserName.setText("姓名:"+user.getUserName());
        lblUserAge.setText("年龄:"+user.getUserAge());
        lblUserSex.setText("性别:"+user.getUserSex());
        lblUserEmail.setText("邮箱:"+user.getUserEmail());
        lblUserPhone.setText("手机:"+user.getUserPhone());
    }
//    用户管理面板
    @FXML
    void UserManage(ActionEvent event) {
        lblTitle.setText("用户管理");
        paneAbout.setVisible(false);
        paneBookManager.setVisible(false);
        paneBorrowManager.setVisible(false);
        paneUserManager.setVisible(true);
        panePersonInfo.setVisible(false);

        userTableView();
    }

//      用户管理面板-用户表格
      void userTableView() {
      Connection conn=null;
      List<User> list=null;
          try {
              conn=JDBCUtils.getConnection();
              list=userDAO.getAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              JDBCUtils.closeResource(conn,null);
          }

       oblist= FXCollections.observableList(list);
       columnUserId.setCellValueFactory(new PropertyValueFactory<>("userID"));
       columnUserPassword.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
       columnUserIdentity.setCellValueFactory(new PropertyValueFactory<>("Identity"));
       columnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
       columnUserAge.setCellValueFactory(new PropertyValueFactory<>("userAge"));
       columnUserSex.setCellValueFactory(new PropertyValueFactory<>("userSex"));
       columnUserEmail.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
       columnUserPhone.setCellValueFactory(new PropertyValueFactory<>("userPhone"));
       userUserTable.setItems(oblist);
    }
//    用户管理面板-添加用户
    @FXML
    void addUser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyUser.fxml"));
            Parent root = loader.load();
            User addUser=new User();
            ModifyUserController controller=loader.getController();
            controller.setUser(addUser);
            controller.setFuntion("addUser");
            controller.setTableView(userUserTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("修改用户信息");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//用户管理面板-删除用户
    @FXML
    void deleteUser(ActionEvent event) {
       Connection conn=null;
       List<User> list=null;
        try {
            conn=JDBCUtils.getConnection();
            userDAO.delete(conn,userUserTable.getSelectionModel().selectedItemProperty().get().getUserID());
            list=userDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist= FXCollections.observableList(list);
        userUserTable.setItems(oblist);
    }
//用户管理面板-修改用户
    @FXML
    void modifyUser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyUser.fxml"));
            Parent root = loader.load();

            ModifyUserController controller=loader.getController();
            User modifyUser=new User(
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserID(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserPassword(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getIdentity(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserName(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserAge(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserSex(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserEmail(),
                    userUserTable.getSelectionModel().selectedItemProperty().get().getUserPhone()
            );
            controller.setUser(modifyUser);
            controller.setFuntion("modifyUser");
            controller.setTableView(userUserTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("修改用户信息");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    用户管理面板-搜索用户
    @FXML
    void SearchUser(ActionEvent event) {
      String userID=textFiledSearchUser.getText();
      Connection conn=null;
      User userSearch=null;
      List<User> list=null;
        try {
            conn=JDBCUtils.getConnection();
            if(userID.equals("")){
                list=userDAO.getAll(conn);
            }else{
                userSearch=userDAO.getUserById(conn,userID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(userID.equals("")){
            oblist= FXCollections.observableList(list);
        }else{
            oblist= FXCollections.observableArrayList(userSearch);
        }
        userUserTable.setItems(oblist);
    }
//    借阅管理面板

    @FXML
    void BorrowManager(ActionEvent event) {
        lblTitle.setText("借阅管理");
        paneAbout.setVisible(false);
        paneBookManager.setVisible(false);
        paneBorrowManager.setVisible(true);
        paneUserManager.setVisible(false);
        panePersonInfo.setVisible(false);
        BookBorrowTable();
    }
//    借阅管理面板-借书表
    void BookBorrowTable(){
        Connection conn=null;
        List<BookBorrow> list=null;
        try {
            conn=JDBCUtils.getConnection();
            list=bookBorrowDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist1= FXCollections.observableList(list);
        columnBookBorrowId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnBookBorrowUserId.setCellValueFactory(new PropertyValueFactory<>("userID"));
        columnBookBorrowBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        columnBookBorrowBorrowTime.setCellValueFactory(new PropertyValueFactory<>("borrowTime"));
        columnBookBorrowReturnTime.setCellValueFactory(new PropertyValueFactory<>("returnTime"));
        BookBorrowTable.setItems(oblist1);
    }
//    借阅管理面板-搜索借书记录
    @FXML
    void BookBorrowSearch(ActionEvent event) {
        String userID=textFiledBookBorrowSearch.getText();
        Connection conn=null;
        BookBorrow bookBorrow=null;
        List<BookBorrow> list=null;
        try {
            conn=JDBCUtils.getConnection();
            if(userID.equals("")){
                list=bookBorrowDAO.getAll(conn);
            }else{
                bookBorrow=bookBorrowDAO.getBookBorrowById(conn,userID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(userID.equals("")){
            oblist1= FXCollections.observableList(list);
        }else{
            oblist1= FXCollections.observableArrayList(bookBorrow);
        }
        BookBorrowTable.setItems(oblist1);
    }

//借阅管理面板-增加借书记录
    @FXML
    void AddBookBorrow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyBookBorrow.fxml"));
            Parent root = loader.load();
            Date date=Date.valueOf("2000-01-01");
            BookBorrow bookBorrow=new BookBorrow(0,"","",date,date);
            ModifyBookBorrowController controller=loader.getController();
            controller.setUser(bookBorrow);
            controller.setFuntion("addBookBorrow");
            controller.setTableView(BookBorrowTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("添加借阅记录");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//借阅管理面板-删除借书记录
    @FXML
    void DeleteBookBorrow(ActionEvent event) {
        Connection conn=null;
        List<BookBorrow> list=null;
        try {
            conn=JDBCUtils.getConnection();
            bookBorrowDAO.delete(conn,BookBorrowTable.getSelectionModel().selectedItemProperty().get().getId());
            list=bookBorrowDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist1= FXCollections.observableList(list);
        BookBorrowTable.setItems(oblist1);
    }
//借阅管理面板-修改借书记录
    @FXML
    void ModifyBookBorrow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyBookBorrow.fxml"));
            Parent root = loader.load();

            ModifyBookBorrowController controller=loader.getController();
            BookBorrow bookBorrow=new BookBorrow(
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getId(),
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getUserID(),
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getBook_id(),
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getBorrowTime(),
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getReturnTime()
            );
            controller.setUser(bookBorrow);
            controller.setFuntion("modifyBookBorrow");
            controller.setTableView(BookBorrowTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("修改用户信息");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    书籍管理面板
    @FXML
    void BookManager(ActionEvent event) {
        lblTitle.setText("图书管理");
        paneAbout.setVisible(false);
        paneBookManager.setVisible(true);
        paneBorrowManager.setVisible(false);
        paneUserManager.setVisible(false);
        panePersonInfo.setVisible(false);
        BookTable();

    }
//   书籍管理面板-书籍表
    void BookTable(){
        Connection conn=null;
        List<Book> list=null;
        try {
            conn=JDBCUtils.getConnection();
            list=bookDAOImpl.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist2= FXCollections.observableList(list);
        columnBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        columnBookName.setCellValueFactory(new PropertyValueFactory<>("book_name"));
        columnBookAuthor.setCellValueFactory(new PropertyValueFactory<>("book_author"));
        columnBookPublishHouser.setCellValueFactory(new PropertyValueFactory<>("book_publishHouse"));
        columnBookPrice.setCellValueFactory(new PropertyValueFactory<>("book_price"));
        columnBookStock.setCellValueFactory(new PropertyValueFactory<>("book_stock"));
        BookTable.setItems(oblist2);
    }
//    书籍管理面板-修改书籍信息
    @FXML
    void modifyBook(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyBook.fxml"));
            Parent root = loader.load();

            ModifyBookController controller=loader.getController();
            Book book=new Book(
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_id(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_name(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_author(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_publishHouse(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_price(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_stock(),
           null
            );
            controller.setUser(book);
            controller.setFuntion("modifyBook");
            controller.setTableView(BookTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("修改书籍信息");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    书籍管理面板-删除书籍
    @FXML
    void deleteBook(ActionEvent event) {
        Connection conn=null;
        List<Book> list=null;
        try {
            conn=JDBCUtils.getConnection();
            bookDAOImpl.delete(conn,BookTable.getSelectionModel().selectedItemProperty().get().getBook_id());
            list=bookDAOImpl.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist2= FXCollections.observableList(list);
        BookTable.setItems(oblist2);
    }
//    书籍管理面板-增加书籍
    @FXML
    void addBook(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModifyBook.fxml"));
            Parent root = loader.load();
            Book book=new Book();
            ModifyBookController controller=loader.getController();
            controller.setUser(book);
            controller.setFuntion("addBook");
            controller.setTableView(BookTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("添加书籍");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//     书籍管理面板-搜索书籍
    @FXML
    void SearchBook(ActionEvent event) {
        String bookName=textFiledSearchBook.getText();
        Connection conn=null;
        Book book=null;
        List<Book> list=null;
        try {
            conn=JDBCUtils.getConnection();
            if(bookName.equals("")){
                list=bookDAOImpl.getAll(conn);
            }else{
                book=bookDAOImpl.getBookByName(conn,bookName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(bookName.equals("")){
            oblist2= FXCollections.observableList(list);
        }else{
            oblist2= FXCollections.observableArrayList(book);
        }
        BookTable.setItems(oblist2);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawer.setSidePane(paneMenu);
        HamburgerBackArrowBasicTransition menu=new HamburgerBackArrowBasicTransition(btnMenu);
        menu.setRate(-1);
        btnMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            menu.setRate(menu.getRate() * -1);
            menu.play();
            if(drawer.isClosed()|| drawer.isClosing()){
                drawer.open();
            }else{
                drawer.close();
            }
        });
    }



}
