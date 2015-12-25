package com.poshidi.study.thinkinjava.c04;
//: OverloadingOrder.java
// Overloading based on the order of the arguments.
/**
 * Created by Administrator on 2015/12/25.
 */
public class OverloadingOrder {
    static void print(String s, int i){
        System.out.println("StringL " + s + ", int:" + i);
    }
    static void print(int i, String s){
        System.out.println("int: " + i + ", String: " + s);
    }

    public static void main(String[] args) {
        print("String first", 11);
        print(99, "Int first");
    }
}
