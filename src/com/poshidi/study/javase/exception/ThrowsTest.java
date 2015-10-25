package com.poshidi.study.javase.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class ThrowsTest {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
