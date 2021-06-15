package com.Gbo601.DAO;

import com.Gbo601.Util.JDBCUtils;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 封装对数据表的通用操作
 * @author Gbo601
 * @create 2021-05-07 11:46
 */
public abstract class BaseDAO<T> {
    private Class<T> clazz=null;
    public BaseDAO()
    {
//        获取当前BaseDao的子类继承的父类中的泛型
        Type genericSuperclass=this.getClass().getGenericSuperclass();
        ParameterizedType paramType=(ParameterizedType) genericSuperclass;
//        获取父类的泛型参数
        Type[] typeArguments=paramType.getActualTypeArguments();
//        泛型的第一个参数
        clazz=(Class<T>)typeArguments[0];
    }
    /**
    * @Description: 通用的增删改操作
    * @Return: int
    * @Author: Gbo601
    * @Date Created in 2021-5-7 11:55
    */
    public int update(Connection conn, String sql, Object... args){
        PreparedStatement ps=null;
        try {
//            预编译sql语句，返回PreparedStatement实例
            ps=conn.prepareStatement(sql);
//            填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
//            执行
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            资源关闭
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }
    /**
    * @Description: 通用的查询，返回数据表一条记录
    * @Return: T
    * @Author: Gbo601
    * @Date Created in 2021-5-7 12:01
    */
    public T getInstance(Connection conn,String sql,Object... args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs=ps.executeQuery();
//            获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd=rs.getMetaData();
//            通过ResultSetMetaData获取结果集中的列数
            int columnCount=rsmd.getColumnCount();
            if(rs.next()){
                T t= clazz.newInstance();
//                处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
//                    获取列值
                    Object columValue=rs.getObject(i+1);
//                    获取每个列的列名
                    String columnLabel=rsmd.getColumnLabel(i+1);
//                    给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field=clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
            return t;
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }
    /**
    * @Description: 通用的查询，返回数据表多条记录
    * @Return: T
    * @Author: Gbo601
    * @Date Created in 2021-5-7 12:29
    */
    public List<T> getForList(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
//          获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
//          通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
//          创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
//              处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
//                  获取列值
                    Object columValue = rs.getObject(i + 1);

//                  获取每个列的列名

                    String columnLabel = rsmd.getColumnLabel(i + 1);

//                  给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);

        }

        return null;
    }
    /**
    * @Description: 用于查询特殊值的通用的方法
    * @Return: E
    * @Author: Gbo601
    * @Date Created in 2021-5-7 12:31
    */
    public <E> E getValue(Connection conn,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
