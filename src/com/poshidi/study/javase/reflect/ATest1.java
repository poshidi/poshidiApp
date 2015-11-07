package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class ATest1 {
    public static void main(String[] args) {
        //创建A类的实例
        A a = new A();
        //让a的实例的a Field值自加
        a.a ++;
        System.out.println(a.a);
    }
}
