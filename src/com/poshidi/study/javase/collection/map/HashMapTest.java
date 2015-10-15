package com.poshidi.study.javase.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/15.
 */
public class HashMapTest {
    public static int MAX_LENGTH = 20000;

    //第一种：普遍使用，二次取值
    public static void itreator1(Map<String,String> map){
        System.out.println("通过Map.keySet遍历key和value：");
        for(String key : map.keySet()){
            System.out.println("key is : " + key + " value is : " + map.get(key));
        }
    }

    //第二种
    public static void itreator2(Map<String,String> map){
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
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
