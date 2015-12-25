package com.poshidi.study.thinkinjava.c03;
//: CastingNumbers.java
// what happens when you cast a float or double to an integral value?
/**
 * Created by Administrator on 2015/12/23.
 */
public class CastingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        System.out.println("above: " + above);
        System.out.println("below: " + below);
        System.out.println("(int)above: " + (int)above);
        System.out.println("(int)below: " + (int)below);
        System.out.println("(char)('a' + above): " + (char)('a' + above));
        System.out.println("(char)('a' + below): " + (char)('a' + below));
    }
}///:~
