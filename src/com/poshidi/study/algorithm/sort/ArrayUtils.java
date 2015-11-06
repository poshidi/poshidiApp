package com.poshidi.study.algorithm.sort;

import java.util.Random;

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

    public static void initArr(int[] arr, int size){
        for(int i = 1; i < size; i++){
            Random random = new Random();
            arr[i] = random.nextInt(100);
        }
    }
}
