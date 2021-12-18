package com.hekaifeng.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = GenerateUtil.generateArr(10, 1, 100);
        System.out.println(Arrays.toString(arr));
        Integer[] tmpArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(tmpArr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(tmpArr);
        System.out.println(Arrays.toString(tmpArr));

        CompareUtil.compareArr(tmpArr, arr);
    }

    /**
     * 1.定义基准值
     * 2.将数组分为小于基准值和大于基准值的两部分
     * 3.重复1，2步骤
     * 4.排好序
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }


    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean less(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) < 0;
    }

    public static void sort(Comparable[] arr, int low, int high) {
        // 数据校验
        if (low >= high) {
            return;
        }
        // 对low到high之间的数据分组，两组
        int partition = partition(arr, low, high);
        // 左组有序
        sort(arr, low, partition - 1);
        // 右组有序
        sort(arr, partition + 1, high);
        // 把两个数组结果进行归并

    }

    public static int partition(Comparable[] arr, int low, int high) {
        // 确定分解值
        Comparable key = arr[low];
        // 定义两个指针
        int leftP = low;
        int rightP = high + 1;
        // 切分
        while (true) {
            // 从右往左扫描，移到一个比分界值小的位置
            while (less(key, arr[--rightP])) {
                if (rightP == low) {
                    break;
                }
            }
            // 从左往右扫描，移到一个比分界值大的位置
            while (less(arr[++leftP], key)) {
                if (leftP == high) {
                    break;
                }
            }
            // 是否left>=right
            if (leftP >= rightP) {
                break;
            } else {
                exchange(arr, leftP, rightP);
            }
        }
        // 交换分界值
        exchange(arr, low, rightP);
        return rightP;
    }
}
