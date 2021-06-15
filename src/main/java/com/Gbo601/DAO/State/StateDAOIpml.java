package com.Gbo601.DAO.State;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.State;

import java.sql.Connection;

/**
 * @author Gbo601
 * @create 2021-05-22 10:15
 */
public class StateDAOIpml extends BaseDAO<State> implements StateDAO{
    @Override
    public State getStateByUserId(Connection conn, String userId) {
        String sql="select userID,num,money,state from book_state where userID=?";
        State state=getInstance(conn,sql,userId);
        return state;
    }

    @Override
    public void updataMoney(Connection conn, State state,double money) {
        String sql="update book_state set money=money+? where userID=?";
        update(conn,sql,money,state.getUserID());
    }

    @Override
    public void updataBorrowNum(Connection conn, String UserID) {
        String sql="update book_state set num=num-1 where userID=?";
        update(conn,sql,UserID);
    }

    @Override
    public void updataReturnNum(Connection conn, String UserID) {
        String sql="update book_state set num=num+1 where userID=?";
        update(conn,sql,UserID);
    }

    @Override
    public int getNumByUserId(Connection conn, String userID) {
      String sql="select num from book_state where userID=?";
      State state=getInstance(conn,sql,userID);
      return state.getNum();
    }

    @Override
    public void insert(Connection conn, State state) {
        String sql="insert into book_state ()value(?,?,?,?)";
        update(conn,sql,state.getUserID(),state.getNum(),state.getMoney(),state.getState());
    }

    @Override
    public void delete(Connection conn, String userID) {
        String sql="delete from book_state where userID=?";
        update(conn,sql,userID);
    }
}
