package com.leetcode;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {


        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();


        for(int i = 0 ; i < s.length() ; i++){

            char c = s.charAt(i);

            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')'){

                char sc = stack.peek();
                if(c == '}' && sc == '{') stack.pop();
                else if(c == ']' && sc == '[') stack.pop();
                else if(c == ')' && sc == '(') stack.pop();
                else return false;
            }

        }

        return stack.size()==0;

    }

}
