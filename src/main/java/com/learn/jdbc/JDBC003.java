package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname JDBC003
 * @Description TODO
 * @Date 2019/10/11 20:06
 * @Created by HeYu5
 */
public class JDBC003 {
    public static void main(String[] args) {
//        Connection c = null;
//        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hutubill?&serverTimezone=UTC&", "root", "admin");
            Statement s = c.createStatement()
        ){



            String sql = "insert into hero values(111,\"thread003\")";
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}