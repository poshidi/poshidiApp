package com.poshidi.dao;

import com.poshidi.bean.Region;

import java.util.List;
import java.util.Map;

/**
 * Created by poshidi on 2015/10/12.
 */
public interface RegionDao {
    public List<Region> getList();

    public List<Map> getMapList();
}
