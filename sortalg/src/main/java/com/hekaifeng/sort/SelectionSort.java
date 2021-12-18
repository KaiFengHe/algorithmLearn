package com.hekaifeng.sort;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            int[] arr = GenerateUtil.generateArr(100, 100, 200);
            System.out.println(Arrays.toString(arr));
            int[] tmpArr = Arrays.copyOf(arr, arr.length);
            System.out.println(Arrays.toString(tmpArr));
            sort(arr);
            System.out.println(Arrays.toString(arr));
            Arrays.sort(tmpArr);
//        Arrays.sort(arr,comparetor);
            System.out.println(Arrays.toString(tmpArr));
            CompareUtil.compareArr(tmpArr, arr);
        }
    }

    /**
     * 选定一个最小索引
     * 和后面依次比较，如果后面有小于当前索引的交换索引位置元素
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 默认第0个元素为最小元素，后续递增
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 最小元素和后面的元素比较，如果有小于的元素替换最小元素索引
                    minIndex = j;
                }
            }
            // 交换假定最小元素索引和真正最小索引
            SwapUtil.swap(arr, i, minIndex);
        }
    }
}
