package com.poshidi.study.thinkinjava.c07.innerscopes;

/**
 * Created by Administrator on 2016/1/25.
 */
//: Parcel14.java
//  Nesting a class within a method
public class Parcel4 {
    public Destination dest(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Tanzania");
    }
}   ///:~
