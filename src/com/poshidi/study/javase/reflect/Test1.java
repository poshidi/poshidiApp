package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class Test1 {
    static {
        //使用静态初始化块为b变量指定初始值
        b = 6;
        System.out.println("----------");
    }
    //声明a变量时指定初始值
    static int a = 5;
    static int b = 9;
    static int c;

    public static void main(String[] args) {
        System.out.println(Test1.b);
    }
}
