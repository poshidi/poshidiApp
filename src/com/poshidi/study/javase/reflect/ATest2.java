package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class ATest2 {
    public static void main(String[] args) {
        //创建A类的实例
        A b = new A();
        //输出b实例的a Field值
        System.out.println(b.a);
    }
}
