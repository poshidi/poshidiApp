package com.poshidi.study.thinkinjava.c06;

/**
 * Created by Administrator on 2016/1/13.
 */
//: Orc.java
// The protected keyword

class Villain{
    private int i;
    protected int read(){
        return i;
    }
    protected void set(int ii){
        i = ii;
    }
    public Villain(int ii){
        i = ii;
    }
    public int value(int m){
        return m*i;
    }
}

public class Orc extends Villain{
    private int j;
    public Orc(int jj){
        super(jj);
        j = jj;
    }
    public void change(int x){
        set(x);
    }

    public static void main(String[] args) {
    }
}   ///:~
