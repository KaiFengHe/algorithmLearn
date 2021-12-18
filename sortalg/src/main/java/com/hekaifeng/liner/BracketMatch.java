package com.hekaifeng.liner;

import java.util.Stack;

/**
 * 括号匹配
 */
public class BracketMatch {

    public static void main(String[] args) {
        String expression = "((1+2)+1";
        boolean isMatch = isMatch(expression);
        System.out.println(isMatch);
    }

    private static boolean isMatch(String expression) {
        Stack<String> chars = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String curChar = expression.charAt(i) + "";
            if ("(".equals(curChar)) {
                chars.push(curChar);
            } else if (")".equals(curChar)) {
                String pop = chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        if (chars.size()==0){
            return true;
        }
        return false;
    }
}
