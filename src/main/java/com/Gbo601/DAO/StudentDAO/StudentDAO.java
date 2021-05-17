package com.Gbo601.DAO.StudentDAO;

import com.Gbo601.Model.Student;


import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-07 12:32
 */
public interface StudentDAO {
    /**
    * @Description: 添加学生记录
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:00
    */
    void insert(Connection conn, Student stu);
    /**
    * @Description: 根据学号删除学生
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:01
    */
    void delete(Connection conn,String Sno);
    /**
    * @Description: 修改学生记录
    * @Return: void
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:02
    */
    void update(Connection conn,Student stu);
    /**
    * @Description: 根据学号查询学生
    * @Return: Student
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:03
    */
    Student getStudentById(Connection conn,String Sno);
    /**
    * @Description: 查询表中的所有记录构成的集合
    * @Return: List<Student></Student>
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:04
    */
    List<Student> getAll(Connection conn);
    /**
    * @Description: 返回数据表中的数据条目数
    * @Return: Long
    * @Author: Gbo601
    * @Date Created in 2021-5-7 17:07
    */
    Long getCount(Connection conn);
}
