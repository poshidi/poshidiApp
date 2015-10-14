package com.poshidi.test;

import com.poshidi.bean.Region;
import com.poshidi.dao.Dao;
import com.poshidi.dao.RegionDao;
import com.poshidi.dao.RegionDaoImp;
import com.poshidi.util.TreeHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/12.
 */
public class RegionTest {
    public static void main(String[] args){
        List<Map> list;
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionDao dao = (RegionDao)context.getBean("RegionDaoImp");
        list = dao.getMapList();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).get("name"));
        }
        //list to json
//        String jsonStr = TreeHelper.getAllChildrenJSONTrees(list, "0000");
//        System.out.println(jsonStr);
    }
}
