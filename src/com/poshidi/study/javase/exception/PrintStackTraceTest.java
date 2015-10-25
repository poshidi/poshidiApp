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
        throw new SelfException("自定义异常信息");
    }
}
class SelfException extends RuntimeException{
    SelfException(){}
    SelfException(String msg){
        super(msg);
    }
}
