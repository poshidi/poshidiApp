package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
class MyTest{
    static{
        System.out.println("��̬��ʼ����...");
    }
    //ʹ��һ���ַ���ֱ����Ϊstatic final Field��ֵ
//    static final String compileConstant = "���Java����";
    static final String compileConstant = System.currentTimeMillis() + "";
}
public class CompileConstantTest {
    public static void main(String[] args) {
        //���ʡ����MyTest�е�compileConstant Field
        System.out.println(MyTest.compileConstant);
    }
}
