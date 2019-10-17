package com.learn.jdbc;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname JDBC002
 * @Description TODO
 * @Date 2019/10/11 19:04
 * @Created by HeYu5
 */
public class JDBC002 {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hutubill?characterEncoding=UTF-8&serverTimezone=UTC&", "root", "admin" );

            s = c.createStatement();

            String sql = "insert into hero values(2,'aaaa')";

            s.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            数据库的连接是有限资源，相关操作结束后养成关闭数据库的好习惯
            if (s!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}