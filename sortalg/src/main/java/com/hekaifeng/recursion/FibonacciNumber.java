package com.hekaifeng.recursion;

/**
 * 斐波那契
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        Long fibonacci = fibonacci(5);
        System.out.println(fibonacci);
    }

    public static Long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1L;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
