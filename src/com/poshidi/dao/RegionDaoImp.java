package com.poshidi.dao;

import com.poshidi.bean.Region;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/12.
 */
public class RegionDaoImp extends SqlMapClientDaoSupport implements RegionDao {
    @Override
    @SuppressWarnings("unchecked")
    public List<Region> getList() {
            return getSqlMapClientTemplate().queryForList("getAllRegions", null);
    }

    @Override
    public List<Map> getMapList() {
        return getSqlMapClientTemplate().queryForList("getAllMapRegions", null);
    }
}
