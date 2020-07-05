package com.leetcode;

import java.util.Arrays;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {

        int nums[] = {};
        int[] temp = new int[nums.length+1];
        Arrays.fill(temp,Integer.MIN_VALUE);

        int left = 0;
        int right = s.length()-1;

        char[] a = {};
        String f = new String(a);
        while(left>=right){

            boolean pointerIncremented = false;
            if(!isValidValue(s.charAt(left))){
                left++;
                pointerIncremented = true;
            }
            if(!isValidValue(s.charAt(right))){
                right--;
                pointerIncremented = true;
            }
            if(pointerIncremented){
                continue;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            else{
                left++;
                right--;
            }


        }
        return true;

    }

    boolean isValidValue(char c){
        return Character.isDigit(c) || Character.isLetter(c);

    }

}
