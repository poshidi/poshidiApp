package com.poshidi.newcoder.d20160104;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Different {
    public static boolean checkDifferent(String iniString) {
        // write code here
        return !iniString.matches(".*(.)(.*\\1).*");
    }

    public static void main(String[] args) {
        System.out.println(checkDifferent("asda"));
    }
}
