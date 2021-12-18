package com.hekaifeng.sort;

public class CompareUtil {
    public static boolean compareArr(Integer[] tmpArr, Integer[] arr) {

        if (tmpArr == null && arr == null) {
            System.out.println("都为空相等");
            return false;
        }

        if (tmpArr != null && arr == null) {
            System.out.println("数组不相等");
            return false;
        }

        if (tmpArr == null) {
            System.out.println("数组不相等");
            return false;
        }

        if (tmpArr.length != arr.length) {
            System.out.println("数组不相等");
            return false;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (tmpArr[i].compareTo(arr[i]) != 0) {
                System.out.println("不相等，fuck");
                return false;
            }
        }

        System.out.println("相等，牛逼");
        return true;
    }
}
