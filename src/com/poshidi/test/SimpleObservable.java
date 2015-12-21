package com.poshidi.test;

import java.util.Observable;

/**
 * Created by Administrator on 2015/11/26.
 */
public class SimpleObservable extends Observable {
    private int data = 0;

    public int getData(){
        return data;
    }

    public void setData(int i){
        if(this.data != i){
            this.data = i;
            setChanged();
        }
        notifyObservers();
        //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
    }
}
