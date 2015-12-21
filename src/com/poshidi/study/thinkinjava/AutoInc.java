package com.poshidi.study.thinkinjava;

/**
 * Created by Administrator on 2015/12/18.
 */
public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        prt("i:" + i);
        prt("++i");
    }
    static void prt(String s){
        System.out.println(s);
    }
}
