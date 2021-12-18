package com.hekaifeng.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            Integer[] arr = GenerateUtil.generateArr(100, 100, 100);
            System.out.println(Arrays.toString(arr));
            Integer[] copyArr = Arrays.copyOf(arr, arr.length);
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

    public static boolean greater(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) > 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 1.选定一个增长量，将数组分组
     * 2.对分组的数组进行插入排序
     * 3.减小增长量的值，最小为1,重复1,2步骤
     * 4.交换次数变少
     *
     * @param arr
     */
    private static void sort(Comparable[] arr) {
        // 确定增长量
        int inc = 1;
        while (inc < arr.length / 2) {
            inc = 2 * inc + 1;
        }
        // 希尔排序
        while (inc >= 1) {
            // 找到待插入的元素
            for (int i = inc; i < arr.length; i++) {
                // 把待插入元素插入到有序数列
                for (int j = i; j >= inc; j -= inc) {
                    // 待插入的是a[j],比较a[j]和a[j-h]
                    if (greater(arr[j - inc], arr[j])) {
                        exchange(arr, j - inc, j);
                    } else {
                        // 待插入元素已找到合适位置
                        break;
                    }
                }
            }
            // 减小增长量
            inc = inc / 2;
        }
    }
}
