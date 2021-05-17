package com.Gbo601.DAO.UserDAO;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.Student;
import com.Gbo601.Model.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-10 21:54
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public boolean verification(Connection conn, String ID,String Password) {
        String sql="select userPassword from User where userID=?";
        User user=getInstance(conn,sql,ID);
        if(user.getUserPassword().equals(Password)){
            return true;
        }else return false;
    }

    @Override
    public int verificationIdentity(Connection conn, String ID) {
        String sql="select Identity from User where userID=?";
        User user=getInstance(conn,sql,ID);
        if(user.getIdentity()==1)return 1;
        else return 2;
    }

    @Override
    public void insert(Connection conn, User user) {
        String sql="insert into User()values(?,?,?,?,?,?,?,?)";
        update(conn,sql,user.getUserID(),user.getUserPassword(),user.getIdentity(),user.getUserName(),user.getUserAge(),user.getUserSex(),user.getUserEmail(),user.getUserPhone());
    }

    @Override
    public void delete(Connection conn, String userID) {
        String sql="delete from User where userID=?";
        update(conn,sql,userID);

    }

    @Override
    public void managerUpdate(Connection conn, User user) {
        String sql="update User set userID=?,userPassword=?,Identity=?,userName=?,userAge=?,userSex=?,userEmail=?,userPhone=?where userID=?";
        update(conn,sql,user.getUserID(),user.getUserPassword(),user.getIdentity(),user.getUserName(),user.getUserAge(),user.getUserSex(),user.getUserEmail(),user.getUserPhone(),user.getUserID());
    }
    public void userUpdate(Connection conn, User user) {
        String sql="update User set userPassword=?,userName=?,userAge=?,userSex=?,userEmail=?,userPhone=?";
        update(conn,sql,user.getUserPassword(),user.getUserName(),user.getUserAge(),user.getUserSex(),user.getUserEmail(),user.getUserPhone());
    }

    @Override
    public void modifyInfo(Connection conn, User user) {
        String sql="update User set userName=?,userAge=?,userSex=?,userEmail=?,userPhone=?where userID=?";
        update(conn,sql,user.getUserName(),user.getUserAge(),user.getUserSex(),user.getUserEmail(),user.getUserPhone(),user.getUserID());
    }

    @Override
    public void modifyPassword(Connection conn, User user) {
        String sql="update User set userPassword=?where userID=?";
        update(conn,sql,user.getUserPassword(),user.getUserID());
    }

    @Override
    public User getUserById(Connection conn, String userID) {
        String sql="select userID,userPassword,Identity,userName,userAge,userSex,userEmail,userPhone from User where userID=?";
        User user=getInstance(conn,sql,userID);
        return user;
    }

    @Override
    public List<User> getAll(Connection conn) {
        String sql="select userID,userPassword,Identity,userName,userAge,userSex,userEmail,userPhone from User";
        List<User>list=getForList(conn,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from User";
        return getValue(conn,sql);
    }

}
