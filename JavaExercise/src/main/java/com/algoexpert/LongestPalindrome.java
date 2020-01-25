package com.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
       // System.out.println(longestPalindromicSubstring("its highnoon"))  abccbait's highnoon;

        System.out.println(longestPalindromicSubstring("a"));
    }

    public static String longestPalindromicSubstring(String str) {

        if(str.length() == 1){
            return str;
        }



        String longest = "";

        for(int i = 1 ; i < str.length() &&  i+1 < str.length() ; i++){

            int p1 = i;
            int p2 = i+1;

            if(str.charAt(p1) == str.charAt(p2)){
                String s = getLongestPalindrome(str,p1,p2);
                if(longest.length() < s.length()){
                    longest  = s;
                }
            }
            if(str.charAt(p1-1) == str.charAt(p2)){
                String s = getLongestPalindrome(str,p1-1,p2);
                if(longest.length() < s.length()){
                    longest  = s;
                }
            }

        }

        return longest;

    }

    public static String getLongestPalindrome(String str,int i, int j){

        while(i>=0 && j < str.length()){

            if(str.charAt(i) == str.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }

        }
        return str.substring(++i,j);
    }

    public static String longestPalindromicSubstringBrute(String str) {
        // Write your code here.
        List<String> list = new ArrayList<>();

        for(int i=0 ; i < str.length() ; i++){
            for(int j = i+1 ; j <= str.length(); j ++){


                list.add(str.substring(i,j));
            }
        }

        Collections.sort(list,(a, b)->Integer.compare(b.length(), a.length()));

        for(String s : list){

            StringBuffer sbr = new StringBuffer(s);
            if(sbr.toString().equals(sbr.reverse().toString())){
                return sbr.toString();
            }

        }

        return "";
    }
}
