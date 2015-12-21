package com.poshidi.test;

/**
 * Created by Administrator on 2015/11/26.
 */
public class SimpleTest {
    public static void main(String[] args){
        SimpleObservable doc = new SimpleObservable ();
        SimpleObserver view = new SimpleObserver (doc);
        doc.setData(1);
        doc.setData(2);
        doc.setData(2);
        doc.setData(3);
    }
}
