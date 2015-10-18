package com.poshidi.study.algorithm.sort;

/**
 * Created by Administrator on 2015/10/15.
 */
public class ArrayUtils {
    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
