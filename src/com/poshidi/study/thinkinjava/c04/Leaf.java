package com.poshidi.study.thinkinjava.c04;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Leaf {
    private int i = 0;
    Leaf increment(){
        i++;
        return this;
    }
    void print(){
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
