package com.poshidi.dao;

/**
 * Created by Administrator on 2015/10/9.
 */
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.poshidi.bean.Ibatis;


public class DaoImp extends SqlMapClientDaoSupport implements Dao {

    public void delete(String id) {
        getSqlMapClientTemplate().delete("deleteUsers", id);
    }

    public Ibatis getById(String id) {
        return (Ibatis)getSqlMapClientTemplate().queryForObject("getUsersById",id);
    }

    public Ibatis getByName(String name) {

        return (Ibatis)getSqlMapClientTemplate().queryForObject("getUsersByName",name);
    }

    @SuppressWarnings("unchecked")
    public List<Ibatis> getList() {
        return getSqlMapClientTemplate().queryForList("getAllUsers",null);
    }

    public void insert(Ibatis ibatis) {
        getSqlMapClientTemplate().insert("insertUsers",ibatis);
    }

    public void update(Ibatis ibatis) {
        getSqlMapClientTemplate().update("updateUsers", ibatis);
    }

}