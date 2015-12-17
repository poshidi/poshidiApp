package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/8
 * @link http://www.poshidi.com
 */
//使用两个注释修饰该类
    @SuppressWarnings(value="unchecked")
    @Deprecated
public class ClassTest {
    //为该类定义一个私用的构造器
    private ClassTest(){
    }
    //定义一个有参数的构造器
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    //定义一个无参数的info方法
    public void info(){
        System.out.println("执行无参数的info方法");
    }
    //定义一个有参数的info方法
    public void info(String str){
        System.out.println("执行有参数的info方法" + ",其str参数值：" + str);
    }
    //定义一个测试用的内部类
//    Class Inner{
//    }

    public static void main(String[] args) throws Exception{

    }
}
