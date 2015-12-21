package com.poshidi.test;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2015/11/26.
 */
public class SimpleObserver implements Observer {
    public SimpleObserver(SimpleObservable simpleObservable){
        simpleObservable.addObserver(this );
    }

    public void update(Observable observable ,Object data){  // data为任意对象，用于传递参数

        System.out.println("Data has changed to" );
    }
}
