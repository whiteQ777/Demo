package com.learn.jdbc;

import com.learn.jdbc.character.Hero;

import java.util.List;

/**
 * @Classname DAO
 * @Description TODO
 * @Date 2019/10/12 20:29
 * @Created by HeYu5
 */
public interface DAO {
    public void add(Hero hero);

    public void update(Hero hero);

    public void delete(int id);

    public Hero get(int id);

    public List<Hero> list();

    public List<Hero> list(int start, int count);
}
