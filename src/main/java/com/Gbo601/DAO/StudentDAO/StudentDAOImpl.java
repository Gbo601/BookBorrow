package com.Gbo601.DAO.StudentDAO;

import com.Gbo601.DAO.BaseDAO;
import com.Gbo601.Model.Student;

import java.sql.Connection;
import java.util.List;

/**
 * @author Gbo601
 * @create 2021-05-07 12:32
 */
public class StudentDAOImpl extends BaseDAO<Student> implements StudentDAO {

    @Override
    public void insert(Connection conn,Student stu){
        String sql="insert into Student()values(?,?,?,?,?,?)";
        update(conn,sql,stu.getSno(),stu.getSname(),stu.getSsex(),stu.getSclass(),stu.getSbirth(),stu.getSphone());
    }

    @Override
    public void delete(Connection conn, String Sno) {
        String sql="delete from Student where Sno=?";
        update(conn,sql,Sno);
    }

    @Override
    public void update(Connection conn, Student stu) {
        String sql="update Student set Sname=?,Ssex=?,Sclass=?,Sbirth=?,Sphone=?where Sno=?";
        update(conn,sql,stu.getSname(),stu.getSsex(),stu.getSclass(),stu.getSbirth(),stu.getSphone(),stu.getSno());
    }

    @Override
    public Student getStudentById(Connection conn, String Sno) {
        String sql="select Sno,Sname,Ssex,Sclass,Sbirth,Sphone from Student where Sno=?";
        Student stu=getInstance(conn,sql,Sno);
        return stu;
    }

    @Override
    public List<Student> getAll(Connection conn) {
        String sql="select Sno,Sname,Ssex,Sclass,Sbirth,Sphone from Student";
        List<Student> list=getForList(conn,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from Student";
        return getValue(conn,sql);
    }

}
