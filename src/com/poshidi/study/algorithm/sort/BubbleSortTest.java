package com.poshidi.study.algorithm.sort;

/**
 * Created by poshidi on 2015/10/19.
 */
public class BubbleSortTest {
    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        int size = 20;
        int[] arr = new int[size];
        ArrayUtils.initArr(arr, size);
        ArrayUtils.printArray(arr);
        BubbleSort(arr);
        ArrayUtils.printArray(arr);
    }
}
