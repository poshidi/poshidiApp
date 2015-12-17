package com.poshidi.study.javase.reflect;

import java.net.URL;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
public class BootstrapTest {
    public static void main(String[] args) {
        //获取根类加载器所加载的全部URL数组
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        //变量、输出根类加载器加载的全部URL
        for(int i = 0; i < urls.length; i++){
            System.out.println(urls[i].toExternalForm());
        }
    }
}
