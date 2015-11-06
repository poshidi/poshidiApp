package com.poshidi.study.algorithm.sort;

/**
 * Created by poshidi on 2015/10/20.
 */
public class HeapSortTest {
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            createMaxdHeap(arr, arr.length - 1 - i);
            swap(arr, 0, arr.length - 1 - i);
            ArrayUtils.printArray(arr);
        }
    }

    public static void createMaxdHeap(int[] arr, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (arr[k] < arr[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(arr, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int size = 200;
        int[] arr = new int[size];
        ArrayUtils.initArr(arr, size);
        ArrayUtils.printArray(arr);
        heapSort(arr);
        System.out.println("排序后的数组：");
        ArrayUtils.printArray(arr);
    }
}
