package com.poshidi.study.javase.exception;

import java.util.Date;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class NullTest {
    public static void main(String[] args){
        Date d = null;
        try{
            System.out.println(d.after(new Date()));
        }catch (NullPointerException ne){
            System.out.println("��ָ���쳣��");
        }catch (Exception e){
            System.out.println("δ֪�쳣");
        }
    }
}
