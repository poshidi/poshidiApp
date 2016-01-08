package com.poshidi.study.thinkinjava.c04;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/7.
 */
//: ArrayNew.java
// Creating arrays with new.
public class ArrayNew {
    static Random rand = new Random();
    static int pRand(int mod){
        return Math.abs(rand.nextInt()) % mod + 1;
    }

    public static void main(String[] args) {
        int[] a;
        a = new int[pRand(20)];
        prt("length of a = " + a.length);
        for(int i = 0; i < a.length; i++)
            prt("a[" + i + "] = " + a[i]);
    }
    static void prt(String s){
        System.out.println(s);
    }
}   ///:~
