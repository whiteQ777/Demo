package com.bill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Classname DButil
 * @Description TODO
 * @Date 2019/10/17 14:47
 * @Created by HeYu5
 */
public class DButil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";
    static String serverTimezone = "UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=%s",ip,port,database,encoding,serverTimezone);
        return DriverManager.getConnection(url, loginName, password);
    }
}