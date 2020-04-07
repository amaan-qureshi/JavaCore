package com.algoexpert;
import java.util.*;
public class LongestSubString {

    public static void main(String[] args) {

        System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
    }

    public static String longestSubstringWithoutDuplication(String str) {

        List a = new ArrayList<String>();
        // Write your code here
        String longestSubString = "";
        int startIndex = 0;
        Map<Character,Integer> map = new HashMap<>();

        int pointer = 0;

        while(pointer<str.length()){

            if(map.containsKey(str.charAt(pointer))){
                startIndex = Math.max(startIndex,map.get(str.charAt(pointer))+1);
                map.put(str.charAt(pointer),pointer);
            }
            else{
                map.put(str.charAt(pointer),pointer);
            }

            String subString = str.substring(startIndex,pointer+1);
            if(subString.length()>longestSubString.length()){
                longestSubString = subString;
            }
            pointer++;

        }

        return longestSubString;
    }
}
