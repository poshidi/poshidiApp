package com.poshidi.study.thinkinjava.c07.innerscopes;

/**
 * Created by Administrator on 2016/2/1.
 */
//: Parcel7.java
//  An anonymous inner class that calls the
//  base-class constructor

public class Parcel7 {
    public Wrapping wrap(int x){
        //Base constructor call:
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };  //Semicolon required
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Wrapping w = p.wrap(10);
    }
}
