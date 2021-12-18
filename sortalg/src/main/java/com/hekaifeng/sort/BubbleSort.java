package com.hekaifeng.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 比较次数i为数组长度-1
     * 如果当前元素大于后面的元素交换往后移动
     * 交换次数和比较次数相同随着排序逐渐变少
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        // 比较次数控制
        for (int i = arr.length - 1; i > 0; i--) {
            // 每次从0开始比较,比较次数随着比较越来越少
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = GenerateUtil.generateArr();
        System.out.println(Arrays.toString(arr));
        Integer[] tmpArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(tmpArr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(tmpArr);
        System.out.println(Arrays.toString(tmpArr));

        CompareUtil.compareArr(tmpArr, arr);
    }


}
