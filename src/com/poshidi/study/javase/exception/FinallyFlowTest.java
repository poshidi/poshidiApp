package com.poshidi.study.javase.exception;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class FinallyFlowTest {
    public static void main(String[] args) throws Exception{
        boolean a = test();
        System.out.println(a);
    }
    public static boolean test(){
        try{
            //��Ϊfinally���а�����return���
            //���������return���ʧȥ����
            return true;
        }finally {
            return false;
        }
    }
}
