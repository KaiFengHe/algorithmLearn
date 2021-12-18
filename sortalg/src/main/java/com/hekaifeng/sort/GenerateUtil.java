package com.hekaifeng.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateUtil {

    public static Integer[] generateArr() {
        Random random = new Random();
        int arrLength = (int) (random.nextFloat() * 100 + 100);
        Integer[] arr = new Integer[arrLength];
        for (int i = 0; i < arrLength; i++) {
            int randomInt = (int) (random.nextFloat() * 100 + 100);
            arr[i] = randomInt;
        }
        return arr;
    }

    public static Integer[] generateArr(int length, int start, int offset) {
        Random random = new Random();
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            int randomInt = (int) (random.nextFloat() * offset + start);
            List<Integer> integers = Arrays.asList(arr);
            while (integers.contains(randomInt)) {
                randomInt = (int) (random.nextFloat() * offset + start);
            }
            arr[i] = randomInt;
        }
        return arr;
    }
}
