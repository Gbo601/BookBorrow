package com.Gbo601.DAO.Announcement;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.Announcement;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-22 10:14
 */
public class AnnouncementDAOIpml extends BaseDAO<Announcement> implements AnnouncementDAO {
    @Override
    public void insert(Connection conn, Announcement announcement) {
        String sql="insert into announcement(date,announcement)value(?,?)";
        update(conn,sql,announcement.getDate(),announcement.getAnnouncement());
    }

    @Override
    public List<Announcement> getAll(Connection conn) {
        String sql="select id,date,announcement from announcement";
        List<Announcement>list=getForList(conn,sql);
        return list;
    }

    @Override
    public void delete(Connection conn, int id) {
        String sql = "delete from announcement where id = ?";
        update(conn, sql,id);
    }
}
