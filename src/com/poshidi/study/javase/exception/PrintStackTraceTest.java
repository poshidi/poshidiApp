package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class PrintStackTraceTest {
    public static void main(String[] args){
        firstMethod();
    }
    public static void firstMethod(){
        secondMethod();
    }
    public static void secondMethod(){
        thirdMethod();
    }
    public static void thirdMethod(){
        throw new SelfException("�Զ����쳣��Ϣ");
    }
}
class SelfException extends RuntimeException{
    SelfException(){}
    SelfException(String msg){
        super(msg);
    }
}
