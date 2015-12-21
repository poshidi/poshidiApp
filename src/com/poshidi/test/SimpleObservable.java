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
        //ֻ����setChange()�����ú�notifyObservers()�Ż�ȥ����update()������ʲô�����ɡ�
    }
}
