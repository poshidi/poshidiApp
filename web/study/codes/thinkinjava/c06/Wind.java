package com.poshidi.study.thinkinjava.c06;

/**
 * Created by Administrator on 2016/1/13.
 */
//: Wind.java
//  Inheritance & upcasting

class Instrument{
    public void play(){}
    static void tune(Instrument i){
        //...
        i.play();
    }
}

//  Wind objects are instruments
//  because they have the same interface:
public class Wind extends Instrument{
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); //Upcasting
    }
}   ///:~
