package com.Gbo601.DAO.State;

import com.Gbo601.Model.State;

import java.sql.Connection;

/**
 * @author Gbo601
 * @create 2021-05-22 10:14
 */
public interface StateDAO {
    /**
    * @Description: 查询一条状态信息
    * @Input: Connection,String
    * @Return: State
    * @Author: Gbo601
    * @Date Created in 2021-5-14 11:14
    */
    State getStateByUserId(Connection conn,String userId);
    /**
    * @Description: 充值金额
    * @Input: Connection,State
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 19:44
    */
    void updataMoney(Connection conn,State state,double money);
    /**
    * @Description: 借书后num减1
    * @Input: Connection,State
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 12:05
    */
    void updataBorrowNum(Connection conn,String UserID);
    /**
    * @Description: 还书后num加1
    * @Input: Connection,String
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 12:07
    */
    void updataReturnNum(Connection conn, String UserID);
    /**
    * @Description: 根据用户名查询当前num
    * @Input: Connection,String
    * @Return: int
    * @Author: Gbo601
    * @Date Created in 2021-5-14 12:08
    */
    int getNumByUserId(Connection conn,String userID);
    /**
    * @Description: 添加用户时新建一个state记录
    * @Input: Connection,State
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 12:57
    */
    void insert(Connection conn,State state);
    /**
    * @Description: 删除用户时删除一个state记录
    * @Input:
    * @Return:
    * @Author: Gbo601
    * @Date Created in 2021-5-14 13:02
    */
    void delete(Connection conn,String userID);
}
