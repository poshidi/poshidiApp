package com.poshidi.study.thinkinjava.c04;

/**
 * Created by Administrator on 2016/1/7.
 */
//: ArrayInit.java
// Array initialization

public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };

        // Java 1.1 only:
        Integer[] b = new Integer[] {
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };
    }
}   ///:~
