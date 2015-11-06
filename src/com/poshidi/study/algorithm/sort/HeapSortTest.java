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
            // ���浱ǰ�����жϵĽڵ�
            int k = i;
            // ����ǰ�ڵ���ӽڵ����
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // �����ӽڵ���ڣ������ʱbiggerIndexӦ�õ��� lastIndex
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        // �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ
                        biggerIndex++;
                    }
                }
                if (arr[k] < arr[biggerIndex]) {
                    // ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ��������biggerIndexֵ��ֵ��k
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
        System.out.println("���������飺");
        ArrayUtils.printArray(arr);
    }
}
