package com.poshidi.study.thinkinjava.c07;

/**
 * Created by Administrator on 2016/1/22.
 */
//: Parcel3.java
//  Returnung a handle to an inner class
abstract class Contents{
    abstract public int value();
}
interface Destination{
    String readLabel();
}
public class Parcel3 {
    private class PContents extends Contents{
        private int i = 11;
        public int value(){ return i; }
    }
    protected class PDestination implements Destination{
        private String label;
        private PDestination(String whereTo){
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }
    public Destination dest(String s){
        return new PDestination(s);
    }
    public Contents cont(){
        return new PContents();
    }
}
class Test{
    public static void main(String[] args) {
        Parcel3 p  = new Parcel3();
        Contents c = p.cont();
        Destination d = p.dest("Tanzania");
        // Illegal -- can't access private class:
        //! Parcel3.PContents c = p.new PContents();
    }
} ///:~
