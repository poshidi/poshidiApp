package com.poshidi.study.javase.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class AccessExceptionMsg {
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("a.txt");
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
