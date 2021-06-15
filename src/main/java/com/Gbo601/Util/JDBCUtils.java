package com.Gbo601.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Gbo601
 * @create 2021-05-06 22:18
 */
public class JDBCUtils {
    /**
     * @Description 基本的获取数据库连接
     * @author Gbo601
     * @create 2021-05-06 22:18
     */


    public static Connection getConnection()throws  Exception{
//        读取配置文件的驱动，url地址，用户名,用户密码
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro=new Properties();
        pro.load(is);

        String user=pro.getProperty("user");
        String password=pro.getProperty("password");
        String url=pro.getProperty("url");
        String driverClass= pro.getProperty("driverClass");
//        装载驱动
        Class.forName(driverClass);
//        获取链接
        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    }
    /**
     * @Description C3P0数据库连接池
     * @author Gbo601
     * @create 2021-05-07 10:59
     */
    private static ComboPooledDataSource cpds=new ComboPooledDataSource("hellc3p0.xml");
    public static Connection getC3P0Connection()throws SQLException{
        Connection conn=cpds.getConnection();
        return conn;
    }
    /**
     * @Description DBCP数据库连接池
     * @author Gbo601
     * @create 2021-05-07 11:12
     */
    /*private static DataSource source;
    static{
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("DBCP.properties"));
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws Exception{
        Connection conn = source.getConnection();
        return conn;
    }*/
    /**
     * @Description Druid数据库连接池
     * @author Gbo601
     * @create 2021-05-07 11:14
     */
    private static DataSource source1;
    static{
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            pros.load(is);

            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws SQLException{

        Connection conn = source1.getConnection();
        return conn;
    }
    /**
     * @Description 关闭连接，Statement操作
     * @author Gbo601
     * @create 2021-05-07 11:15
     */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if(ps!=null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * @Description 关闭连接，Statement,资源操作
     * @author Gbo601
     * @create 2021-05-07 11:19
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        try {
            if(ps!=null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
