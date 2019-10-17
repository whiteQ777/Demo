package com.learn.jdbc;

import com.learn.jdbc.character.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HeroDAO
 * @Description TODO
 * @Date 2019/10/12 20:16
 * @Created by HeYu5
 */
public class HeroDAO implements DAO {
    public HeroDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33.6/hutubill?serverTimezone = UTC", "root", "admin");
        return c;
    }

    public int getTotal(){
        int total = 0;
        try (Connection c = getConnection();
             Statement s = c.createStatement()
        ){
            String sql = "SELECT count(*) FROM hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Hero hero) {
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Hero hero) {
        String sql = "update hero set name = ?, hp = ?, damage = ?, where id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){

            ps.setString(1, hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            ps.setInt(4,hero.id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try(Connection c = getConnection();
            Statement s = c.createStatement()
        ) {
            String sql = "delete from hero where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Hero get(int id) {
        Hero hero = null;
        try(Connection c = getConnection();
            Statement s = c.createStatement()) {
            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.damage =damage;
                hero.hp = hp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hero;
    }

    @Override
    public List<Hero> list() {

        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();

        String sql = "select * from hero order by id desc limit ?, ?";

        try( Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                heros.add(hero);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return heros;
    }
}