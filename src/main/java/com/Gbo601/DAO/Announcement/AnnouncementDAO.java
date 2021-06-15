package com.Gbo601.DAO.Announcement;

import com.Gbo601.Model.Announcement;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-22 10:14
 */
public interface AnnouncementDAO {
    /**
    * @Description: 添加一条公告
    * @Input: Connection,Announcement
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:18
    */
    void insert(Connection conn, Announcement announcement);
    /**
    * @Description: 获取所有公告
    * @Input: Connection
    * @Return: List<Announcement></>
    * @Author: Gbo601
    * @Date Created in 2021-5-14 10:20
    */
    List<Announcement> getAll(Connection conn);
    /**
    * @Description:
    * @Input:
    * @Return:
    * @Author: Gbo601
    * @Date Created in 2021-5-14 20:36
    */
    void delete(Connection conn,int id);
}
