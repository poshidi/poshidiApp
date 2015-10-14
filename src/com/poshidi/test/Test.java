package com.poshidi.test;

/**
 * Created by Administrator on 2015/10/9.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poshidi.bean.Ibatis;
import com.poshidi.dao.Dao;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Dao dao = (Dao)context.getBean("DaoImp");
        dao.insert(new Ibatis("2","new3"));
        Ibatis ibatis3 = dao.getById("2");
        ibatis3.setName("new7");
        dao.update(ibatis3);
//       testDAOImpl.delete("3");
        System.out.println("获得全查询列表");
        List<Ibatis> result=new ArrayList<Ibatis>();
        result = dao.getList();
        for (Iterator<Ibatis> iter = result.iterator(); iter.hasNext();) {
            Ibatis element = (Ibatis) iter.next();
            System.out.println(element.getName());
        }
    }

}