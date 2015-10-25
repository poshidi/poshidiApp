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
    //����һ�����Խ���Throwable�����Ĺ�����
    public SalException(Throwable t){
        super(t);
    }
}
