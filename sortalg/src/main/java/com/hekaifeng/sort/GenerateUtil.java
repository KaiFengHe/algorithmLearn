package com.hekaifeng.sort;

import java.util.Random;

public class GenerateUtil {

    public static int[] generateArr() {
        Random random = new Random();
        int arrLength = (int) (random.nextFloat() * 100 + 100);
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            int randomInt = (int) (random.nextFloat() * 100 + 100);
            arr[i] = randomInt;
        }
        return arr;
    }

    public static int[] generateArr(int length, int start, int offset) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int randomInt = (int) (random.nextFloat() * offset + start);
            arr[i] = randomInt;
        }
        return arr;
    }
}
