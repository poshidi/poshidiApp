package com.poshidi.study.thinkinjava;

import java.util.Random;

/**
 * Created by Administrator on 2015/12/18.
 */
public class MathOps {
    //Create a shorthand to save typing;
    static void prt(String s) {
        System.out.println(s);
    }
    //shorthand to print a string and an int;
    static void pInt(String s, int i) {
        prt(s + " = " + i);
    }
    //shorthand to print a string and a floag;
    static void pFlt(String s, float f){
        prt(s + " = " + f);
    }

    public static void main(String[] args) {
        //Create a random number generator,
        // seeds with current time by defalut;
        Random rand = new Random();
        int i, j, k;
        //'%' limits maximum value to 99;
        j = rand.nextInt() % 100;
        k = rand.nextInt() % 100;
        pInt("j", j);
        pInt("k", k);
        i = j + k; pInt("j + k", i);
        i = j - k; pInt("j - k", i);
        i = j / k; pInt("j / k", i);
        i = j * k; pInt("j * k", i);
        i = j % k; pInt("j % k", i);
        j %= k; pInt("j %= k", j);
        //Floating-point number tests:
        float u, v, w; //applies to doubles, too
        v = rand.nextFloat();
        w = rand.nextFloat();
        pFlt("v", v); pFlt("w", w);
        u = v + w; pFlt("v + w", u);
        u = v - w; pFlt("v - w", u);
        u = v * w; pFlt("v * w", u);
        u = v / w; pFlt("v / w", u);
        //the following also works for char, byte, short, int, long, and double;
        u += v; pFlt("u += v", u);
        u -= v; pFlt("u -= v", u);
        u *= v; pFlt("u *= v", u);
        u /= v; pFlt("u /= v", u);
    }
}
