package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class Test1 {
    static {
        //ʹ�þ�̬��ʼ����Ϊb����ָ����ʼֵ
        b = 6;
        System.out.println("----------");
    }
    //����a����ʱָ����ʼֵ
    static int a = 5;
    static int b = 9;
    static int c;

    public static void main(String[] args) {
        System.out.println(Test1.b);
    }
}
