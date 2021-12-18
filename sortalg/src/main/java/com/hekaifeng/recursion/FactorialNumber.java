package com.hekaifeng.recursion;

/**
 * 阶乘
 */
public class FactorialNumber {

    public static void main(String[] args) {
        Long factorial = factorial(3);
        System.out.println(factorial);
    }

    /**
     * 求n的阶乘
     *
     * @param n
     * @return
     */
    public static Long factorial(int n) {
        if (n == 1) {
            return 1L;
        }
        return n * factorial(n - 1);
    }
}
