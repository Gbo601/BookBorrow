package com.Gbo601.GUI.Controller;

import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Model.User;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Gbo601
 * @create 2021-05-11 8:01
 */
public class UserMenuController implements Initializable {
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
    private Label lblUserName;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblUserAge;

    @FXML
    private Label lblUserSex;

    @FXML
    private Label lblUserEmail;

    @FXML
    private Label lblUserPhone;

    @FXML
    private JFXButton btnModifyInfo;

    @FXML
    private JFXButton btnModifyPassword;

    @FXML
    private Label lblUserName11;

    @FXML
    private Label lblUserName1;

    @FXML
    private Label lblUserName111;

    @FXML
    private Pane paneBookCheck;

    @FXML
    private TableView<Book> BookTable;

    @FXML
    private TableColumn<?, ?> columnBookId;

    @FXML
    private TableColumn<?, ?> columnBookName;

    @FXML
    private TableColumn<?, ?> columnBookAuthor;

    @FXML
    private TableColumn<?, ?> columnBookPublishHouser;

    @FXML
    private TableColumn<?, ?> columnBookPrice;

    @FXML
    private TableColumn<?, ?> columnBookStock;

    @FXML
    private Button btnBookCheckBorrow;

    @FXML
    private TextField textFiledSearchBook;

    @FXML
    private Button btnSearchBook;

    @FXML
    private Pane paneBookBorrow;

    @FXML
    private TableView<BookBorrow> BookBorrowTable;

    @FXML
    private TableColumn<BookBorrow, String> columnBookBorrowId;

    @FXML
    private TableColumn<Book, String> columnBookBorrowBookName;

    @FXML
    private TableColumn<BookBorrow,Date> columnBookBorrowBorrowTime;

    @FXML
    private TableColumn<BookBorrow,Date> columnBookBorrowReturnTime;

    @FXML
    private Button btnRenew;

    @FXML
    private Button btnReturnBook;

    @FXML
    private TextField textFiledBookBorrowSearch;

    @FXML
    private Button btnBookBorrowSearch;

    @FXML
    private TableView<?> BookBorrowTable1;

    @FXML
    private TableColumn<?, ?> columnBookReturnRecordId;

    @FXML
    private TableColumn<?, ?> columnBookReturnRecordUserId;

    @FXML
    private TableColumn<?, ?> columnBookReturnRecordBookId;

    @FXML
    private TableColumn<?, ?> columnBookReturnRecordBorrowTime;

    @FXML
    private TableColumn<?, ?> columnBookReturnRecordReturnTime;

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
    private JFXButton btnBookCheck;

    @FXML
    private JFXButton btnBookBorrowReturn;

    @FXML
    private JFXButton btnAbout;

    @FXML
    private JFXButton btnExit1;

    @FXML
    private Label lblBookName;

    private int index;
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
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Exit1(ActionEvent event) {
        System.exit(0);

    }
    @FXML
    void About(ActionEvent event) {
        lblTitle.setText("关于");
        paneAbout.setVisible(true);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(false);
    }

//    个人信息面板
    @FXML
    void PersonInfo(ActionEvent event) {
        lblTitle.setText("个人信息");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(true);

        lblUserId.setText("账号:"+user.getUserID());
        lblUserName.setText("姓名:"+user.getUserName());
        lblUserAge.setText("年龄:"+user.getUserAge());
        lblUserSex.setText("性别:"+user.getUserSex());
        lblUserEmail.setText("邮箱:"+user.getUserEmail());
        lblUserPhone.setText("手机:"+user.getUserPhone());

    }
    //    个人信息面板-修改信息
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
    //    个人信息面板-修改密码
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
                conn= JDBCUtils.getConnection();
                userDAO.modifyPassword(conn,modifyUser);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeResource(conn,null);
            }
        }
    }
    //图书查阅面板
    @FXML
    void BookCheck(ActionEvent event) {
        lblTitle.setText("图书管理");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(true);
        panePersonInfo.setVisible(false);
        BookTable();
    }
    //图书查阅面板-书表
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
    //图书查阅面板-图书借阅
    @FXML
    void BookCheckBorrow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookBorrowSelectTime.fxml"));
            Parent root = loader.load();
            Date date=null;
            BookBorrow bookBorrow=new BookBorrow(
                    0,
                    user.getUserID(),
                    BookTable.getSelectionModel().selectedItemProperty().get().getBook_id(),
                    date,
                    date
            );
            Book book=new Book();
            book.setBook_id(BookTable.getSelectionModel().selectedItemProperty().get().getBook_id());
            BookBorrowSelectTimeController controller=loader.getController();
            controller.setUser(bookBorrow);
            controller.setBook(book);
            controller.setTable(BookTable);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("借阅");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //图书查阅面板-搜索图书
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
//    借阅、归还面板
    @FXML
    void BookBorrowReturn(ActionEvent event) {
        lblTitle.setText("借阅/归还");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(true);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(false);
        BookBorrowTable();
    }
//借阅、归还面板-我的借阅
    void BookBorrowTable(){
        Connection conn=null;
        List<BookBorrow> list=null;
        try {
            conn=JDBCUtils.getConnection();
            list=bookBorrowDAO.getPersonAll(conn,user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist1= FXCollections.observableList(list);
        columnBookBorrowId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnBookBorrowBookName.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        columnBookBorrowBorrowTime.setCellValueFactory(new PropertyValueFactory<>("borrowTime"));
        columnBookBorrowReturnTime.setCellValueFactory(new PropertyValueFactory<>("returnTime"));
        BookBorrowTable.setItems(oblist1);
    }
    @FXML
    void BookBorrowSearch(ActionEvent event) {
        String userID=textFiledBookBorrowSearch.getText();
        Connection conn=null;
        BookBorrow bookBorrow=null;
        List<BookBorrow> list=null;
        try {
            conn=JDBCUtils.getConnection();
            if(userID.equals("")){
                list=bookBorrowDAO.getPersonAll(conn,user);
            }else{
                bookBorrow=bookBorrowDAO.getPersonBookBorrowById(conn,userID,user);
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

    @FXML
    void ReturnBook(ActionEvent event) {
        Connection conn=null;
        List<BookBorrow> list=null;
        Book book=new Book();
        book.setBook_id(BookBorrowTable.getSelectionModel().selectedItemProperty().get().getBook_id());
        try {
            conn=JDBCUtils.getConnection();
            bookBorrowDAO.delete(conn,BookBorrowTable.getSelectionModel().selectedItemProperty().get().getId());

            int stock=bookDAOImpl.getStock(conn,book.getBook_id())+1;
            book.setBook_stock(stock);
            bookDAOImpl.updateStock(conn,book);

            list=bookBorrowDAO.getPersonAll(conn,user);
        } catch (Exception e) {
            e.printStackTrace();
            showDialog("提示","还书失败");
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        oblist1= FXCollections.observableList(list);
        BookBorrowTable.setItems(oblist1);
    }

    @FXML
    void Renew(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookBorrowSelectTime.fxml"));
            Parent root = loader.load();
            Date date=null;
            BookBorrow bookBorrow=new BookBorrow(
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getId(),
                    user.getUserID(),
                    BookBorrowTable.getSelectionModel().selectedItemProperty().get().getBook_id(),
                    date,
                    date
            );
            Book book=new Book();
            book.setBook_id(BookBorrowTable.getSelectionModel().selectedItemProperty().get().getBook_id());
            BookBorrowSelectTimeController controller=loader.getController();
            controller.setUser(bookBorrow);
            controller.setBook(book);
            controller.setBookBorrowTable(BookBorrowTable);
            controller.setFuntion("Renew");
            controller.setuserUser(user);

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("续借");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    设置弹窗
    @FXML
    void Mins(ActionEvent event) {

    }
    public void showDialog(String Heading,String Body){
        JFXAlert alert = new JFXAlert((Stage) btnBookCheckBorrow.getScene().getWindow());
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
