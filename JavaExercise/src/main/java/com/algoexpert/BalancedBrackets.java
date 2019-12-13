package com.algoexpert;

import java.util.LinkedList;

public class BalancedBrackets {


    public static boolean balancedBrackets(String exp) {
        // Write your code here.

        LinkedList<Character> pArr = new LinkedList<>();

        for (int i = 0; i < exp.length(); i++) {

            if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(') {
                pArr.push(exp.charAt(i));
            } else if (exp.charAt(i) == '}' || exp.charAt(i) == ']' || exp.charAt(i) == ')') {

                boolean removed = false;

                if (!pArr.isEmpty() && pArr.peek() == '{' && exp.charAt(i) == '}') {
                    pArr.pop();
                    removed = true;
                } else if (!pArr.isEmpty() &&pArr.peek() == '[' && exp.charAt(i) == ']') {

                    pArr.pop();
                    removed = true;
                } else if (!pArr.isEmpty() &&pArr.peek() == '(' && exp.charAt(i) == ')') {
                    pArr.pop();
                    removed = true;
                }

                if (!removed) {
                    return removed;
                }
            }
        }

        return pArr.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets(")[]}"));
    }


}



