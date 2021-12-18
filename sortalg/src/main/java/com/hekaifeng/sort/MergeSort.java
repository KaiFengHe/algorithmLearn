package com.hekaifeng.sort;

import java.util.Arrays;

public class MergeSort {

    // 归并辅助数组
    private static Comparable[] assist;

    public static void main(String[] args) {
        Integer[] arr = GenerateUtil.generateArr(20, 1, 100);
        System.out.println(Arrays.toString(arr));
        Integer[] tmpArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(tmpArr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(tmpArr);
        System.out.println(Arrays.toString(tmpArr));

        CompareUtil.compareArr(tmpArr, arr);
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

    public static void sort(Comparable[] arr) {
        // 初始化辅助数组
        assist = new Comparable[arr.length];
        // 定义low和high变量记录最低索引和最高索引
        int low = 0;
        int high = arr.length - 1;
        // 调用重载方法完成数组中low到high的元素的排序
        sort(arr, low, high);
    }

    public static void sort(Comparable[] arr, int low, int high) {
        // 数据校验
        if (low >= high) {
            return;
        }
        // 对low到high之间的数据分组，两组
        int mid = low + (high - low) / 2; // 5,9  mid=7
        // 分组对每一组排序
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        // 把两个数组结果进行归并
        merge(arr, low, mid, high);
    }

    /**
     * 从low到mid一组，mid+1到high一组，将两组数组归并
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(Comparable[] arr, int low, int mid, int high) {
        // 定义三个指针
        int currentP = low;
        int leftP = low;
        int rightP = mid + 1;
        // 遍历移动left指针和right指针，比较左右指针找出小的那个，放到辅助数组索引处。
        while (leftP <= mid && rightP <= high) {
            if (less(arr[leftP], arr[rightP])) {
                assist[currentP] = arr[leftP];
                leftP++;
            } else {
                assist[currentP] = arr[rightP];
                rightP++;
            }
            currentP++;
        }
        // 如果left遍历走完，接着遍历right
        while (leftP <= mid) {
            assist[currentP] = arr[leftP++];
            currentP++;
        }
        // 如果right遍历走完，接着遍历left
        while (rightP <= high) {
            assist[currentP] = arr[rightP++];
            currentP++;
        }
        // 把辅助数组的值copy到原数组中
        for (int index = low; index <= high; index++) {
            arr[index] = assist[index];
        }
    }
}
