package com.learn.jdbc;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

/**
 * @Classname JDBC005
 * @Description 数据库查询
 * @Date 2019/10/11 21:46
 * @Created by HeYu5
 */
public class JDBC005 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
             Statement s = c.createStatement()
        ){
            String sql = "Select * from hero";

//            执行查询语句，并把结果返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                System.out.printf("%d\t%s\n", id, name);
            }



            } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}