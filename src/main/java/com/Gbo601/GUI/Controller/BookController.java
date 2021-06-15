package com.Gbo601.GUI.Controller;

import com.Gbo601.GUI.MyListener;
import com.Gbo601.Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gbo601
 * @create 2021-05-18 18:51
 */
public class BookController {
    @FXML
    private Label lblBookName;

    @FXML
    private ImageView imgBook;

    @FXML
    private Label lblBookAuthor;

    @FXML
    private Label lblBookpublishHourse;

    @FXML
    private Label lblStock;


    private Book book;
    private MyListener myListener;

    @FXML
    void click(MouseEvent event) {
        myListener.onClickListene(book);
    }
    public void setData(Book book,MyListener myListener){
        this.book=book;
        this.myListener=myListener;
        lblBookName.setText(book.getBook_name());
        lblStock.setText("库存:"+book.getBook_stock());
        lblBookAuthor.setText("作者:"+book.getBook_author());
        lblBookpublishHourse.setText("出版社:"+book.getBook_publishHouse());

        InputStream is=null;
        is=new ByteArrayInputStream(book.getBook_image());
        Image image=new Image(is);
        imgBook.setImage(image);
        try {
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

