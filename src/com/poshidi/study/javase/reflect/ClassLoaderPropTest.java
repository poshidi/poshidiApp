package com.poshidi.study.javase.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException{
        //��ȡϵͳ�������
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("ϵͳ���������" + systemLoader);
        /*
        ��ȡϵͳ��������ļ���·��--ͨ����CLASSPATH��������ָ��
        �������ϵͳû��ָ��CLASSPATH������������Ĭ���Ե�ǰ·����Ϊ
        ϵͳ��������ļ���·��
         */
        URL em1 = systemLoader.getResource("");
        //��ȡϵͳ��������ĸ�����������õ���չ�������
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("��չ���������" + extensionLader);
        System.out.println("��չ��������ļ���·����" + System.getProperty("java.ext.dirs"));
        System.out.println("��չ���������parent:" + extensionLader.getParent());
    }
}
