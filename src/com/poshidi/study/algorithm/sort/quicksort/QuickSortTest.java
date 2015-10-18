package com.poshidi.study.algorithm.sort.quicksort;

import com.poshidi.study.algorithm.sort.ArrayUtils;

import java.util.Random;

/**
 * @author poshidi
 * @date 2015/10/18
 * @link http://www.poshidi.com
 */
public class QuickSortTest {
    public static void quick(int[] str) {
        if (str.length > 0) {    //查看数组是否为空
            _quickSort(str, 0, str.length - 1);
        }
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public static void init(int[] list){
        for(int i = 1; i < 20; i++){
            Random random = new Random();
            list[i] = random.nextInt(100);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[20];
        init(array);
        long start = System.currentTimeMillis();
        QuickSortTest qs=new QuickSortTest();
        ArrayUtils.printArray(array);
        qs.quick(array);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("排序共用了" + time);
        ArrayUtils.printArray(array);

    }
}
