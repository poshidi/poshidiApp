package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class AuctionException extends Exception{
    //无参数的构造器
    public AuctionException(){}
    //带一个字符串参数的构造器
    public AuctionException(String msg){
        super(msg);
    }
}
