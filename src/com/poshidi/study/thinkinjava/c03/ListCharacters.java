package com.poshidi.study.thinkinjava.c03;

/**
 * Created by Administrator on 2015/12/23.
 */
public class ListCharacters {
    public static void main(String[] args) {
        for(char c = 0; c < 128; c ++){
            if(c != 26) //ANSI Clear screen
                System.out.println("value: " + (int)c + " character: " + c);
        }
    }
}
