package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class SalException extends Exception{
    public SalException() {}
    public SalException(String msg){
        super(msg);
    }
    //创建一个可以接收Throwable参数的构造器
    public SalException(Throwable t){
        super(t);
    }
}
