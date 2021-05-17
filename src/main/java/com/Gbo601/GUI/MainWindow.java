package com.Gbo601.GUI;

import com.Gbo601.Main.Test;
import com.Gbo601.Util.JDBCUtils;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author Gbo601
 * @create 2021-05-07 17:36
 */
public class MainWindow {
    public void login(){
        String user,password;
        Scanner scan=new Scanner(System.in);

        while(true){
            System.out.println("账号:");
            user= scan.next();
            System.out.println("密码:");
            password= scan.next();
            Connection conn=null;
            try {
                conn=JDBCUtils.getConnection();
                if(conn!=null){
                    System.out.println("登录成功");
                    show();
                    break;
                }
            } catch (Exception e) {
                System.out.println("登录失败，请重新登录");
            } finally {
                JDBCUtils.closeResource(conn,null);
            }
        }


    }
    public void show(){
        System.out.println("_____________________________________________________");
        System.out.println("1-添加学生");
        System.out.println("2-删除学生");
        System.out.println("3-修改学生信息");
        System.out.println("4-查询学生信息");
        System.out.println("5-查看全部学生信息");
        System.out.println("6-查看学生人数");
        System.out.println("7-退出");
        System.out.println("_____________________________________________________");
        Scanner scan=new Scanner(System.in);
        int i=0;
        i= scan.nextInt();
        Test test=new Test();
        while(true){
            if(i==7)break;
            switch (i){
                case 1:test.insertStudent();break;
                case 2:test.deleteStudent();break;
                case 3:test.updateStudent();break;
                case 4:test.getStudent();break;
                case 5:test.getAllStudent();break;
                case 6:test.getStudentCount();break;
                case 7:break;
                default: System.out.println("输入错误请重新输入");break;
            }
            System.out.println("_____________________________________________________");
            System.out.println("1-添加学生");
            System.out.println("2-删除学生");
            System.out.println("3-修改学生信息");
            System.out.println("4-查询学生信息");
            System.out.println("5-查看全部学生信息");
            System.out.println("6-查看学生人数");
            System.out.println("7-退出");
            System.out.println("_____________________________________________________");
            i= scan.nextInt();
        }

    }
}
