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

    public void update(Observable observable ,Object data){  // dataΪ����������ڴ��ݲ���

        System.out.println("Data has changed to" );
    }
}
