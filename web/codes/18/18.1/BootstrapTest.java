package com.poshidi.study.javase.reflect;

import java.net.URL;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
public class BootstrapTest {
    public static void main(String[] args) {
        //��ȡ��������������ص�ȫ��URL����
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        //���������������������ص�ȫ��URL
        for(int i = 0; i < urls.length; i++){
            System.out.println(urls[i].toExternalForm());
        }
    }
}
