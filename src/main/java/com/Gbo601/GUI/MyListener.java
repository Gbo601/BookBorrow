package com.Gbo601.GUI;


import com.Gbo601.Model.Book;
import com.Gbo601.Model.BookBorrow;

public interface MyListener {
    public void onClickListene(Book book);
    public void onCLickListenerBorrow(BookBorrow bookBorrow);
}
