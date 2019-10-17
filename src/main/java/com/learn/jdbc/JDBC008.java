package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Classname JDBC008
 * @Description TODO
 * @Date 2019/10/12 12:21
 * @Created by HeYu5
 */
public class JDBC008 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hutubill?serverTimezone=UTC","root","admin");
            Statement s = c.createStatement()
        ) {
            String sql = "DELETE FROM hero where id = 1";

            c.setAutoCommit(false);
            System.out.println("是否删除数据：Y则删除，N则不删除 ");
            Scanner input = new Scanner(System.in);
            String isDel = input.next();
            if(isDel == "Y") {
                for (int i = 0; i < 10; i++){
                    s.execute(sql);
                }
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}