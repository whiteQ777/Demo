package com.bill.dao;

import com.bill.Entity.Config;
import com.bill.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ConfigDAO
 * @Description TODO
 * ConfigDAO专门用于把config实例与Config表进行ORM映射
 * ORM映射就是 ConfigDAO负责把Config实例转换成一条Config表中的记录，反过来又把config表中的记录转换为一个config实例
 *
 * @Date 2019/10/17 16:35
 * @Created by HeYu5
 */
public class ConfigDAO {
    public int getTotal(){
        int total = 0;
        try (Connection c = DButil.getConnection();
             Statement s = c.createStatement();){

            String sql = "SELECT count * from config";

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total: " + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Config config){
        String sql = "insert into config values (null,?,?)";
        try(Connection c = DButil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, config.key);
            ps.setString(2, config.value);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection c = DButil.getConnection();
            Statement s = c.createStatement()
        ) {
            String sql = "delete from config where id = " + id;
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Config get(int id){
        Config config = null;
        try (Connection c = DButil.getConnection();
             Statement s = c.createStatement()){


            String sql = "select * form config where id  = "+ id;
            ResultSet rs = s.executeQuery(sql);

            if(rs.next()){
                config = new Config();
                config.id = id;
                config.key = rs.getString(2);
                config.value = rs.getString(3);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(){
        return list(0, Short.MAX_VALUE);
    }

    public List<Config> list(int start, int count){
        List<Config> configs = new ArrayList<Config>();
        String sql = "select * from config order by id desc limit ?,?";
        try (Connection c = DButil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Config config = new Config();
                config.id = rs.getInt(1);
                config.key = rs.getString(2);
                config.value = rs.getString(3);
                configs.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configs;
    }

    public Config getByKey(String key){
        Config config = null;
        try (Connection c = DButil.getConnection();
            Statement s = c.createStatement()
        ){
            String sql = "select * from config where key_ = " + key;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                config = new Config();
                config.id = rs.getInt(1);
                config.key = key;
                config.value = rs.getString(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

}