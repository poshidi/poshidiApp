package com.poshidi.study.thinkinjava.c07;

/**
 * Created by Administrator on 2016/1/15.
 */
//: Music.java
//  Inheritance & upcasting
class Note{
    private int value;
    private Note(int val){
        value = val;
    }
    public static final Note
        middleC = new Note(0),
        cSharp = new Note(1),
        cFlat = new Note(2);
}   // Etc.
class Instrument{
    public void play(Note n){
        System.out.println("Instrument.play()");
    }
}
//  Wind objects are instruments
//  because they have the same interface3:
class Wind extends Instrument{
    //  Redefine interface method:
    public void play(Note n){
        System.out.println("Wind.play()");
    }
}
public class Music {
    public static void tune(Instrument i){
        // ...
        i.play(Note.middleC);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);    //  Upcasting
    }
}   ///:~
