package com.hekaifeng.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            int[] arr = GenerateUtil.generateArr(100, 100, 100);
            System.out.println(Arrays.toString(arr));
            int[] copyArr = Arrays.copyOf(arr, arr.length);
            System.out.println(Arrays.toString(copyArr));

            sort(arr);
            System.out.println(Arrays.toString(arr));
            Arrays.sort(copyArr);
            boolean isTrue = CompareUtil.compareArr(arr, copyArr);
            if (!isTrue) {
                break;
            }
        }
    }

    /**
     * 1.让第一个位置作为最小元素,i循环控制
     * 2.后面的所有元素依次和前面比较大小
     * 3.
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        // 假定第一个位置已有序，依次递增从第二个元素开始插入
        for (int i = 1; i < arr.length; i++) {
            // 后面元素依次和前面的元素倒序比较,所以内存循环从大到小
            for (int j = i - 1; j >= 0; j--) {
                // 交换后，在已排好序的部分，两两比较冒泡将最小的排到合适的位置
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
