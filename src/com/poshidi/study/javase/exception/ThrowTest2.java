package com.poshidi.study.javase.exception;

import java.io.FileOutputStream;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class ThrowTest2 {
    public static void main(String[] args)
        //Java6����Ϊ1�Ŵ�������׳�Exception�쳣
        //���Դ˴������׳�Exception�쳣
        throws Exception
    {
        try{
            new FileOutputStream("a.txt");
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex; //1
        }

    }
}
