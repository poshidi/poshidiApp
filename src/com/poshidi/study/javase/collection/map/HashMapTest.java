package com.poshidi.study.javase.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/15.
 */
public class HashMapTest {
    public static int MAX_LENGTH = 20000;

    //��һ�֣��ձ�ʹ�ã�����ȡֵ
    public static void itreator1(Map<String,String> map){
        System.out.println("ͨ��Map.keySet����key��value��");
        for(String key : map.keySet()){
            System.out.println("key is : " + key + " value is : " + map.get(key));
        }
    }

    //�ڶ���
    public static void itreator2(Map<String,String> map){
        System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String>();
        //put
        map.put("1", "robot");
        //get
        System.out.println(map.get("1"));

        for(int i = 0; i < MAX_LENGTH; i++){
            String key = String.valueOf(i);
            String val = "java" + key;
            map.put(key, val);
        }

        //size
        System.out.println("map's length is " + map.size());

        //itreator1(map);
        itreator2(map);
    }
}
