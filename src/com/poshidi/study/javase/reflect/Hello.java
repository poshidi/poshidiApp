package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/8
 * @link http://www.poshidi.com
 */
public class Hello {
    public static void main(String[] args) {
        for(String arg : args){
            System.out.println("运行Hello的参数：" + arg);
        }
    }
}
