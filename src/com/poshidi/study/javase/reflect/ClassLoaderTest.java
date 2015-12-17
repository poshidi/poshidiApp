package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
class Tester{
    static{
        System.out.println("Tester��ľ�̬��ʼ����...");
    }
}
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        //������������Ǽ���Tester��
        cl.loadClass("Tester");
        System.out.println("ϵͳ����Tester��");
        //�������Ż��ʼ��Tester��
        Class.forName("Tester");
    }
}
