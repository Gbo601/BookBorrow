package com.Gbo601.DAO.BookBorrow;

import com.Gbo601.Model.BookBorrow;
import com.Gbo601.Model.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-14 10:19
 */
public interface BookBorrowDAO {
    /**
    * @Description: 借书时添加一条借书记录
    * @Input: Connection,BookBorrow
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-11 10:20
    */
    void insert(Connection conn, BookBorrow bookBorrow);
    /**
    * @Description: 还书后删除借书记录
    * @Input: Connection,String
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:23
    */
    void delete(Connection conn,int book_id);
    /**
    * @Description: 修改借书记录,用与管理员修改
    * @Input: Connection,BookBorrow
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:28
    */
    void managerUpdate(Connection conn,BookBorrow bookBorrow);
    /**
    * @Description: 用于用户续借
    * @Input: Connection,BookBorrow
    * @Return:void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:31
    */
    void userRenewUpdate(Connection conn,BookBorrow bookBorrow);
    /**
    * @Description: 根据userID查询借书记录
    * @Input: Connection,String
    * @Return: BookBorrow
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:32
    */
    BookBorrow getBookBorrowById(Connection conn,String userID);
    /**
    * @Description: 用户查询借书记录
    * @Input: Connection,String
    * @Return: BookBorrow
    * @Author: Gbo601
    * @Date Created in 2021-5-14 14:28
    */
    BookBorrow getPersonBookBorrowById(Connection conn,String book_id,User user);
    /**
    * @Description: 查询全部借书记录
    * @Input: List<BookBorrow>
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:34
    */
    List<BookBorrow> getAll(Connection conn);
    /**
    * @Description: 获取个人的借书记录
    * @Input:
    * @Return:
    * @Author: Gbo601
    * @Date Created in 2021-5-15 13:57
    */
    List<BookBorrow> getPersonAll(Connection conn, User user);
}
