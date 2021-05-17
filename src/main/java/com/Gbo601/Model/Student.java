package com.Gbo601.Model;

import java.sql.Date;
/**
 * @Description 对应数据库表中的Student表
 * @author Gbo601
 * @create 2021-05-07 11:30
 */
public class Student {
    private String Sno;
    private String Sname;
    private String Ssex;
    private String Sclass;
    private Date Sbirth;
    private String Sphone;

    public Student() {

    }

    public Student(String sno, String sname, String ssex, String sclass, Date sbirth, String sphone) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sclass = sclass;
        Sbirth = sbirth;
        Sphone = sphone;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }

    public Date getSbirth() {
        return Sbirth;
    }

    public void setSbirth(Date sbirth) {
        Sbirth = sbirth;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sclass='" + Sclass + '\'' +
                ", Sbirth=" + Sbirth +
                ", Sphone='" + Sphone + '\'' +
                '}';
    }
}
