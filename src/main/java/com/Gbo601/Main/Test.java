package com.Gbo601.Main;

import com.Gbo601.DAO.StudentDAO.StudentDAOImpl;
import com.Gbo601.GUI.MainWindow;
import com.Gbo601.Model.Student;
import com.Gbo601.Util.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gbo601
 * @create 2021-05-07 17:34
 */
public class Test {
    private StudentDAOImpl stuDAO=new StudentDAOImpl();

    public static void main(String[] args) {
        MainWindow main=new MainWindow();
        main.login();
    }
    public void ConnectTest(){
        try {
            Connection conn=JDBCUtils.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertStudent(){
        Connection conn=null;
        String sno,sname,ssex,sclass,birthDate,sphone;
        Scanner scan=new Scanner(System.in);
        try {
            conn= JDBCUtils.getConnection();
            System.out.print("请输入学号:");
            sno= scan.next();
            System.out.print("请输入姓名:");
            sname= scan.next();
            System.out.print("请输入性别:");
            ssex= scan.next();
            System.out.print("请输入班级:");
            sclass= scan.next();
            System.out.print("请输入生日:");
            birthDate= scan.next();
            System.out.print("请输入手机号:");
            sphone= scan.next();
            Date date=Date.valueOf(birthDate);
            Student stu=new Student(sno,sname,ssex,sclass,date,sphone);
            stuDAO.insert(conn,stu);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    public void deleteStudent(){
        Connection conn=null;
        String sno=null;
        try {
            conn=JDBCUtils.getConnection();
            Scanner scan=new Scanner(System.in);
            System.out.print("输入学号:");
            sno= scan.next();
            stuDAO.delete(conn,sno);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    public void updateStudent(){
        Connection conn=null;
        String sno,sname,ssex,sclass,birthDate,sphone;
        Scanner scan=new Scanner(System.in);
        try {
            conn=JDBCUtils.getConnection();
            System.out.print("请输入修改学生的学号:");
            sno= scan.next();
            System.out.print("请输入姓名:");
            sname= scan.next();
            System.out.print("请输入性别:");
            ssex= scan.next();
            System.out.print("请输入班级:");
            sclass= scan.next();
            System.out.print("请输入生日:");
            birthDate= scan.next();
            System.out.print("请输入手机号:");
            sphone= scan.next();
            Date date=Date.valueOf(birthDate);
            Student stu=new Student(sno,sname,ssex,sclass,date,sphone);
            stuDAO.update(conn,stu);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }
    public void getStudent(){
        Connection conn=null;
        String sno=null;
        try {
            conn=JDBCUtils.getConnection();
            Scanner scan=new Scanner(System.in);
            System.out.print("输入学号:");
            sno= scan.next();
            Student stu=stuDAO.getStudentById(conn,sno);
            System.out.println(stu);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    public void getAllStudent(){
        Connection conn=null;

        try {
            conn=JDBCUtils.getConnection();
            List<Student> list=stuDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    public void getStudentCount(){
        Connection conn=null;

        try {
            conn=JDBCUtils.getConnection();
            Long count=stuDAO.getCount(conn);

            System.out.println("共有学生："+count+"人");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }


}
