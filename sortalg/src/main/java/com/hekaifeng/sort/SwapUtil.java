package com.hekaifeng.sort;

public class SwapUtil {

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
