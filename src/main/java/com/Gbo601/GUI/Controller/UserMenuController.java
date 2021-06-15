package com.Gbo601.GUI.Controller;

import animatefx.animation.*;
import com.Gbo601.DAO.Announcement.AnnouncementDAOIpml;
import com.Gbo601.DAO.BookBorrow.BookBorrowDAOIpml;
import com.Gbo601.DAO.BookDAO.BookDAOImpl;
import com.Gbo601.DAO.State.StateDAOIpml;
import com.Gbo601.DAO.UserDAO.UserDAOImpl;
import com.Gbo601.GUI.MyListener;
import com.Gbo601.Model.*;
import com.Gbo601.Util.JDBCUtils;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private ImageView imgBook;

    @FXML
    private Label lblBookNName;

    @FXML
    private Label lblBookAuthor;

    @FXML
    private Label lblBookStock;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;


    @FXML
    private VBox paneInfo;
    @FXML
    private VBox paneAnnouncement;

    @FXML
    private VBox paneAnother;


    @FXML
    private Pane paneSearch;

    @FXML
    private Pane paneBookBrowse;


    @FXML
    private VBox paneChosenBook;

    @FXML
    private Pane paneTop;


    @FXML
    private VBox paneModifyInfo;

    @FXML
    private Label lblBorrowName;

    @FXML
    private Label lblBookBorrowBorrowTime;

    @FXML
    private Label lblBookBorrowReturnTime;


    @FXML
    private GridPane gridBorrowBook;

    @FXML
    private GridPane gridAnnouncement;


    @FXML
    private Label lblHaveBorrow;

    @FXML
    private Label lblBalance;

    @FXML
    private Label lblCanBorrow;

    @FXML
    private VBox paneBorrowBookOperation;

    @FXML
    private HBox paneBorrowBookRecord;

    @FXML
    private JFXButton btnCharge;

    private static String userId;
    private static User user;
    private static State state;
    private final UserDAOImpl userDAO=new UserDAOImpl();
    private final BookBorrowDAOIpml bookBorrowDAO=new BookBorrowDAOIpml();
    private BookDAOImpl bookDAOImpl=new BookDAOImpl();
    private AnnouncementDAOIpml announcementDAOIpml=new AnnouncementDAOIpml();
    private StateDAOIpml stateDAOIpml=new StateDAOIpml();

    private Book book;
    private BookBorrow bookBorrow;

    MyListener mylistener;
    MyListener mylistener1;
    Image image;



    public void setUser(User User){
        user=User;
    }
    public void setUserId(){
        userId=user.getUserID();
    }
    public void setState(State sstate){
        state=sstate;
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
        new FadeIn(paneTop).play();
        paneAbout.setVisible(true);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(false);
    }

//    个人信息面板
    @FXML
    void PersonInfo(ActionEvent event) {

        new FadeIn(paneTop).play();
        lblTitle.setText("个人信息");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(true);

        new ZoomIn(paneInfo).setSpeed(1.4).play();
        new ZoomInRight(paneAnnouncement).setSpeed(1.4).play();
        new ZoomInDown(paneAnother).setSpeed(1.4).play();
        new ZoomInUp(paneModifyInfo).setSpeed(1.7).play();

        lblUserId.setText("账号:"+user.getUserID());
        lblUserName.setText("姓名:"+user.getUserName());
        lblUserAge.setText("年龄:"+user.getUserAge());
        lblUserSex.setText("性别:"+user.getUserSex());
        lblUserEmail.setText("邮箱:"+user.getUserEmail());
        lblUserPhone.setText("手机:"+user.getUserPhone());
        lblHaveBorrow.setText("已借:"+(8-state.getNum())+"本");
        lblBalance.setText("余额:"+state.getMoney());
        lblCanBorrow.setText("还能借:"+state.getNum()+"本");
        AnnouncementTable();

    }

    void AnnouncementTable(){
        Connection conn=null;
        List<Announcement> list=null;

        try {
            conn=JDBCUtils.getConnection();
            list=announcementDAOIpml.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        gridAnnouncement.getChildren().clear();
        int row=0;

        try {
            for (int i = list.size()-1; i >=0; i--) {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/Announcement.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();
                AnnouncementController controller=fxmlLoader.getController();
                controller.setData(list.get(i));

                gridAnnouncement.add(anchorPane,0,row);
                row++;
                gridAnnouncement.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridAnnouncement.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridAnnouncement.setMaxWidth(Region.USE_COMPUTED_SIZE);
                gridAnnouncement.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridAnnouncement.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridAnnouncement.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane,new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Charge(ActionEvent event) {

        TextInputDialog dialog=new TextInputDialog();
        dialog.setTitle("充值");
        dialog.setContentText("请输入充值金额");

        Optional<String> word=dialog.showAndWait();
        if(word.isPresent()){
            String money=word.get();
            double money1=Double.parseDouble(money);
            if(money1<=0){
                showDialog("提示","请输入正确金额",btnCharge);
            }
            else{
                Connection conn=null;
                try {
                    conn= JDBCUtils.getConnection();
                    stateDAOIpml.updataMoney(conn,state,money1);
                    state=stateDAOIpml.getStateByUserId(conn,state.getUserID());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JDBCUtils.closeResource(conn,null);
                }
            }

        }
        lblHaveBorrow.setText("已借:"+(8-state.getNum())+"本");
        lblBalance.setText("余额:"+state.getMoney());
        lblCanBorrow.setText("还能借:"+state.getNum()+"本");
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
            System.exit(0);
        }
    }
    //图书查阅面板
    @FXML
    void BookCheck(ActionEvent event) {
        new FadeIn(paneTop).play();
        lblTitle.setText("图书查阅");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(false);
        paneBookCheck.setVisible(true);
        panePersonInfo.setVisible(false);

        new ZoomIn(paneBookBrowse).setSpeed(1.6).play();
        new ZoomIn(paneSearch).setSpeed(1.6).play();
        new ZoomIn(paneChosenBook).setSpeed(1.6).play();
        BookTable();
    }
    void setChosenBook(Book book){
        this.book=book;
        lblBookNName.setText(""+book.getBook_name());
        lblBookAuthor.setText("作者:"+book.getBook_author());
        lblBookStock.setText("库存:"+book.getBook_stock());
        InputStream is=null;
        is=new ByteArrayInputStream(book.getBook_image());
        image=new Image(is);
        imgBook.setImage(image);
        try {
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if(list.size()>0){
            setChosenBook(list.get(0));
            mylistener=new MyListener() {
                @Override
                public void onClickListene(Book book) {
                    setChosenBook(book);
                }

                @Override
                public void onCLickListenerBorrow(BookBorrow bookBorrow) {

                }
            };
        }
        grid.getChildren().clear();
        int column=0;
        int row=1;
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/book.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();

                BookController controller=fxmlLoader.getController();
                controller.setData(list.get(i),mylistener);

                if(column==4){
                    column=0;
                    row++;
                }

                grid.add(anchorPane,column++,row);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane,new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    book.getBook_id(),
                    date,
                    date
            );
            BookBorrowSelectTimeController controller=loader.getController();
            controller.setUser(bookBorrow);
            controller.setBook(book);

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
        try {
            conn=JDBCUtils.getConnection();
            book=bookDAOImpl.getBookByName(conn,bookName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        this.book=book;
        if(bookName.equals("")){
            BookTable();
        }else{
            try {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/book.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();

                BookController controller=fxmlLoader.getController();
                controller.setData(book,mylistener);

                grid.getChildren().clear();
                grid.add(anchorPane,0,1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    借阅、归还面板
    @FXML
    void BookBorrowReturn(ActionEvent event) {
        new FadeIn(paneTop).play();
        lblTitle.setText("借阅/归还");
        paneAbout.setVisible(false);
        paneBookBorrow.setVisible(true);
        paneBookCheck.setVisible(false);
        panePersonInfo.setVisible(false);
        new ZoomIn(paneBorrowBookOperation).setSpeed(1.6).play();
        new ZoomIn(paneBorrowBookRecord).setSpeed(1.6).play();

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
        if(list.size()>0){
            setChosenBorrowBook(list.get(0));
            mylistener1=new MyListener() {
                @Override
                public void onClickListene(Book book) {

                }
                @Override
                public void onCLickListenerBorrow(BookBorrow bookBorrowbook) {
                    setChosenBorrowBook(bookBorrowbook);
                }
            };
        }
        gridBorrowBook.getChildren().clear();
        int row=0;
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/bookBorrowBar.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();

                BookBorrowBarController controller=fxmlLoader.getController();
                controller.setData(list.get(i),mylistener1);
                row++;
                gridBorrowBook.add(anchorPane,0,row);
                //set grid width
                gridBorrowBook.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridBorrowBook.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridBorrowBook.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridBorrowBook.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridBorrowBook.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridBorrowBook.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane,new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setChosenBorrowBook(BookBorrow bookBorrow){
        this.bookBorrow=bookBorrow;
        Book book=null;
        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            book=bookDAOImpl.getBookById(conn,bookBorrow.getBook_id());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        lblBorrowName.setText(book.getBook_name());
        lblBookBorrowBorrowTime.setText(bookBorrow.getBorrowTime().toString());
        lblBookBorrowReturnTime.setText(bookBorrow.getReturnTime().toString());
    }
    @FXML
    void ReturnBook(ActionEvent event) {
        Connection conn=null;
        Book book=new Book();
        book.setBook_id(bookBorrow.getBook_id());
        int index=-1;
        try {
            conn=JDBCUtils.getConnection();
            bookBorrowDAO.delete(conn,bookBorrow.getId());
//          库存+1
            int stock=bookDAOImpl.getStock(conn,book.getBook_id())+1;
            book.setBook_stock(stock);
            bookDAOImpl.updateStock(conn,book);
//          状态num+1
            stateDAOIpml.updataReturnNum(conn,user.getUserID());
            state=stateDAOIpml.getStateByUserId(conn,user.getUserID());
            index=1;
        } catch (Exception e) {
            e.printStackTrace();
            showDialog("提示","还书失败",btnReturnBook);
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(index==1){
            showDialog("提示","还书成功",btnReturnBook);
        }
        BookBorrowTable();
    }

    @FXML
    void Renew(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookBorrowSelectTime.fxml"));
            Parent root = loader.load();
            Date date=null;
            BookBorrow bookBorrow=new BookBorrow(
                    this.bookBorrow.getId(),
                    user.getUserID(),
                    this.bookBorrow.getBook_id(),
                    date,
                    date
            );
            Book book=new Book();
            book.setBook_id(this.bookBorrow.getBook_id());
            BookBorrowSelectTimeController controller=loader.getController();
            controller.setUser(bookBorrow);
            controller.setBook(book);
            controller.setFuntion("Renew");

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
    public void showDialog(String Heading,String Body,Button btn){
        JFXAlert alert = new JFXAlert((Stage) btn.getScene().getWindow());
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
