package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class ThreadExceptionTest implements Runnable{
    @Override
    public void run() {
        firstMethod();
    }
    public void firstMethod(){
        secondMethod();
    }
    public void secondMethod(){
        int a = 5;
        int b = 0;
        int c = a / b;
    }
    public static void main(String[] args){
        new Thread(new ThreadExceptionTest()).start();
    }
}
