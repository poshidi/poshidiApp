package com.poshidi.study.thinkinjava.c06;

/**
 * Created by Administrator on 2016/1/14.
 */
//: BlankFinal.java
//  "Blank" final data members
class Poppet{}

public class BlankFinal {
    final int i = 0;    //  Initialized final
    final int j;    //  Blank final
    final Poppet p; //  Blank final
    //  Blank finals MUST be initialized
    //  in the constructor:
    BlankFinal(){
        j = 1;  //  Initialize blank final
        p = new Poppet();
    }
    BlankFinal(int x){
        j = x;  //  Initialize blank final
        p = new Poppet();
    }

    public static void main(String[] args) {
        BlankFinal bf = new BlankFinal();
    }
}   ///:~
