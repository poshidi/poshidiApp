package com.poshidi.study;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Test {
    public static void main(String[] args) {
        float i = Float.NaN, j = 0;
        System.out.println(i);
        if(i > j || i <= j){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

