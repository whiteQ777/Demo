package com.learn.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @Classname JDBC007
 * @Description TODO
 * @Date 2019/10/12 9:23
 * @Created by HeYu5
 */
public class JDBC007 {
    public static void list(int start, int count){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hutubill?serverTimezone=UTC","root","admin");
             Statement s = c.createStatement()
        ){
            String sql = "select * from hero limit " + start+ "," + count;

//            方法1：executeQuery()
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                System.out.printf("%d\t%s\n", id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入起始值：");
        int start = input.nextInt();
        System.out.println("请输入count： ");
        int count = input.nextInt();
        list(start,count);
    }
}