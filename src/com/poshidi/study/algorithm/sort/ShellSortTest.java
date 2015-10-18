package com.poshidi.study.algorithm.sort;

/**
 * Created by Administrator on 2015/10/15.
 */
public class ShellSortTest {

    public static void shellSort(int[] array) {
        double d1 = array.length;
        int temp = 0;
        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i += d) {
                    int j = i - d;
                    temp = array[i];
                    for (; j >= 0 && temp < array[j]; j -= d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
            if (d == 1)
                break;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, -1, 0, -8, 2, 1};
        ArrayUtils.printArray(array);
        shellSort(array);
        ArrayUtils.printArray(array);
    }
}
