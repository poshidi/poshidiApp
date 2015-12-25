package com.poshidi.study.thinkinjava.c03;

/**
 * Created by Administrator on 2015/12/23.
 */
public class CommaOperator {
    public static void main(String[] args) {
        for(int i = 1, j = i + 10; i < 5; i++, j= i * 2){
            System.out.println("i= " + i + " j= " + j);
        }
    }
}
