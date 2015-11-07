package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class Test {
    //声明a变量时指定初始值
    static int a = 5;
    static int b;
    static int c;
    static
    {
        //使用静态初始化块为b变量指定初始值
        b = 6;
    }
}
