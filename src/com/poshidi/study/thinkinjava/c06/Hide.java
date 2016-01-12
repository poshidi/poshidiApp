package com.poshidi.study.thinkinjava.c06;

/**
 * Created by Administrator on 2016/1/12.
 */
//: Hide.java
// Overloading a base-class method name in a derived class does not hide
// the base-class versions

class Homer{
    char doh(char c){
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f){
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer{
    void doh(Milhouse m){}
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);   // doh(float) used
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}   ///:~
