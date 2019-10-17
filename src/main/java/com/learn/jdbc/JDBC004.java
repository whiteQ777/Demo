package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname JDBC004
 * @Description TODO
 * @Date 2019/10/11 20:48
 * @Created by HeYu5
 */
public class JDBC004 {

    public static void execute(String sql){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root", "admin");
             Statement s = c.createStatement()
        ){
            s.execute(sql);
            } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        execute("select id from hero");

    }
}