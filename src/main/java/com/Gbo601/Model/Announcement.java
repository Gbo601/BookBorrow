package com.Gbo601.Model;

import java.sql.Date;

/**
 * @author Gbo601
 * @create 2021-05-22 10:09
 */
public class Announcement {
    private int id;
    private Date date;
    private String announcement;

    public Announcement() {
    }

    public Announcement(int id, Date date, String announcement) {
        this.id = id;
        this.date = date;
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", date=" + date +
                ", announcement='" + announcement + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
