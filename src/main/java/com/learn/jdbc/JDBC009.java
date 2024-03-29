package com.learn.jdbc;

/**
 * @Classname JDBC009
 * @Description TODO ORM对象和关系数据库映射
 * @Date 2019/10/12 12:51
 * @Created by HeYu5
 */
import com.learn.jdbc.character.Hero;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC009 {

    public static Hero get(int id){
        Hero hero = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
            Statement s = c.createStatement()) {

            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

//            因为id是唯一的 ResultSet最多只能有一条记录
//            所以使用if代替while
            if(rs.next()){
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage=damage;
                hero.id = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hero;
    }


    public static void add(Hero h){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into hero values(null,?,?,?)";
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
            PreparedStatement ps = c.prepareStatement(sql)) {

//            设置参数
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);

            ps.execute();


            } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(Hero h) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "update hero set name = ?, hp = ?, damage = ? where id = ? ";

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
             PreparedStatement ps = c.prepareStatement(sql);){

//            设置参数
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(4,h.id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void delete(Hero h){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "delete from hero where id = ?";
        try ( Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
            PreparedStatement ps = c.prepareStatement(sql);

        ){
//            设置参数
            ps.setInt(1,h.id);
            ps.execute();

           } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Hero> list() {
        List<Hero> heros = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hutubill?serverTimezone=UTC","root","admin");
             Statement s = c.createStatement()){

            String sql = "SELECT * FROM hero";

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                Hero hero = new Hero();
                int id =rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getInt("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                heros.add(hero);


            }


        } catch (SQLException e) {
            e.printStackTrace();

        }

        return heros;
    }

    public static void main(String[] args) {
        List<Hero> hs = list();;
        System.out.println("数据库共有" + hs.size() + "条数据");
        Hero h = new Hero();
        h.name = "新的英雄";
        System.out.println("新加一条数据");
        add(h);
        hs = list();
        System.out.println("数据库共有" + hs.size() + "条数据");

        System.out.print("取出id = 3的数据，她的name是：");
        h = get(3);
        System.out.println(h.name);

        System.out.println("删除id= 3的数据");
        delete(h);
        hs = list();
        System.out.println("数据库共有" + hs.size() + "条数据");
    }


}