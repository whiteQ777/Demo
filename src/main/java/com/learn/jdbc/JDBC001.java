package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname JDBC001
 * @Description TODO
 * @Date 2019/10/11 14:39
 * @Created by HeYu5
 */
public class JDBC001 {

        public static void main(String[] args) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 建立与数据库的Connection连接
                // 这里需要提供：
                // 数据库所处于的ip:127.0.0.1 (本机)
                // 数据库的端口号： 3306 （mysql专用端口号）
                // 数据库名称 how2java
                // 编码方式 UTF-8
                // 账号 root
                // 密码 admin

                Connection c = DriverManager
                        .getConnection(
                                "jdbc:mysql://127.0.0.1:3306/hutubill?useSSL=false&serverTimezone=UTC",
                                "root", "admin");

                System.out.println("连接成功，获取连接对象： " + c);

                Statement s = c.createStatement();

                String sql = "create table hero(id int(11), name varchar(255))";

                s.execute(sql);

                System.out.println("获取statement对象：" + s);



            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

}