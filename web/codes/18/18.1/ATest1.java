package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/1
 * @link http://www.poshidi.com
 */
public class ATest1 {
    public static void main(String[] args) {
        //����A���ʵ��
        A a = new A();
        //��a��ʵ����a Fieldֵ�Լ�
        a.a ++;
        System.out.println(a.a);
    }
}
