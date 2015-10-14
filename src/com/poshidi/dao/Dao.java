package com.poshidi.dao;

/**
 * Created by poshidi on 2015/10/9.
 */
import com.poshidi.bean.Ibatis;

import java.util.List;
public interface Dao {
    public List<Ibatis> getList();
    public Ibatis getByName(String name);
    public Ibatis getById(String id);
    public void insert(Ibatis ibatis);
    public void delete(String id);
    public void update(Ibatis ibatis);
}