package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/8
 * @link http://www.poshidi.com
 */
//ʹ������ע�����θ���
    @SuppressWarnings(value="unchecked")
    @Deprecated
public class ClassTest {
    //Ϊ���ඨ��һ��˽�õĹ�����
    private ClassTest(){
    }
    //����һ���в����Ĺ�����
    public ClassTest(String name){
        System.out.println("ִ���в����Ĺ�����");
    }
    //����һ���޲�����info����
    public void info(){
        System.out.println("ִ���޲�����info����");
    }
    //����һ���в�����info����
    public void info(String str){
        System.out.println("ִ���в�����info����" + ",��str����ֵ��" + str);
    }
    //����һ�������õ��ڲ���
//    Class Inner{
//    }

    public static void main(String[] args) throws Exception{

    }
}
