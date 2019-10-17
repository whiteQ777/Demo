package com.learn.jdbc;

import java.sql.*;

/**
 * @Classname JDBC006
 * @Description 判断账号密码是否正确
 * @Date 2019/10/11 22:24
 * @Created by HeYu5
 */
public class JDBC006 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hutubill?serverTimezone=UTC","root","admin");
             Statement s = c.createStatement()
        ){
            String sql = "select * from users where user = \"root\" and password = \"admin\"";

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){
                System.out.println("密码正确");
            }else{
                System.out.println("密码错误");
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}