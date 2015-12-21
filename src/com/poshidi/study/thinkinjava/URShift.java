package com.poshidi.study.thinkinjava;

/**
 * Created by Administrator on 2015/12/21.
 */
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        i >>>= 10;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        byte b = -1;
        b >>>= 10;
        System.out.println(b);

        int j = -10;
        j >>= 1;
        System.out.println(j);
    }
}
