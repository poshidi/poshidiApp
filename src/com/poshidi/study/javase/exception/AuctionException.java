package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class AuctionException extends Exception{
    //�޲����Ĺ�����
    public AuctionException(){}
    //��һ���ַ��������Ĺ�����
    public AuctionException(String msg){
        super(msg);
    }
}
