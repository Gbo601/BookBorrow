package com.Gbo601.DAO.UserDAO;

import com.Gbo601.Model.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-10 21:42
 */
public interface UserDAO  {
    /**
    * @Description: 验证用户密码是否正确
    * @Input: Connection,String,String
    * @Return: boolean
    * @Author: Gbo601
    * @Date Created in 2021-5-10 21:43
    */
    public boolean verification(Connection conn,String userID,String userPassword);
    /**
    * @Description: verificationIdentity
    * @Input: Connection,String
    * @Return: char
    * @Author: Gbo601
    * @Date Created in 2021-5-10 8:34
    */
    public int verificationIdentity(Connection conn,String userID);
    /**
    * @Description: 添加用户
    * @Input: Connection,User
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:20
    */
    void insert(Connection conn, User user);
    /**
    * @Description: 根据ID删除用户
    * @Input: Connection,String
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:20
    */
    void delete(Connection conn,String userID);
    /**
    * @Description: 管理员修改信息
    * @Input: Connection,User
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:21
    */
    void managerUpdate(Connection conn,User user);
    /**
    * @Description: 用户修改信息
    * @Input: Connection,User
    * @Return:
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:56
    */
    void userUpdate(Connection conn,User user);

    /**
    * @Description: 个人修改信息
    * @Input: Connection,User
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-12 10:38
    */
    void modifyInfo(Connection conn,User user);
    /**
     * @Description: 修改密码
     * @Input: Connection,User
     * @Return: void
     * @Author: Gbo601
     * @Date Created in 2021-5-12 10:32
     */
    void modifyPassword(Connection conn,User user);
    /**
    * @Description: 根据ID查询用户
    * @Input: Connection,String
    * @Return: User
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:22
    */
    User getUserById(Connection conn,String userID);
    /**
    * @Description: 查询所用用户
    * @Input: Connection
    * @Return: List<User>
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:24
    */
    List<User> getAll(Connection conn);
    /**
    * @Description: 获取全部用户数
    * @Input: Connection
    * @Return: Long
    * @Author: Gbo601
    * @Date Created in 2021-5-11 19:26
    */
    Long getCount(Connection conn);


}
