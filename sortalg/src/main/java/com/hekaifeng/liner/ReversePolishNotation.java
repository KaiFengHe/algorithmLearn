package com.hekaifeng.liner;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        // 3*(17-15)+18/6
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int caculate = caculate(notation);
        System.out.println(caculate);
    }

    public static int caculate(String[] notation) {
        Stack<Integer> operations = new Stack<>();
        for (String curStr : notation) {
            Integer result;
            Integer o1;
            Integer o2;
            switch (curStr) {
                case "+":
                    o1 = operations.pop();
                    o2 = operations.pop();
                    result = o2 + o1;
                    operations.push(result);
                    break;
                case "-":
                    o1 = operations.pop();
                    o2 = operations.pop();
                    result = o2 - o1;
                    operations.push(result);
                    break;
                case "*":
                    o1 = operations.pop();
                    o2 = operations.pop();
                    result = o2 * o1;
                    operations.push(result);
                    break;
                case "/":
                    o1 = operations.pop();
                    o2 = operations.pop();
                    result = o2 / o1;
                    operations.push(result);
                    break;
                default:
                    operations.push(Integer.parseInt(curStr));
                    break;
            }
        }
        return operations.pop();
    }
}
