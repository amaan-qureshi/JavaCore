package com.leetcode;

public class MatrixRotation {

    public static void main(String[] args) {
        System.out.println(new MatrixRotation().longestPalindrome("abb"));
    }

    public String longestPalindrome(String str) {

        if(str.length() == 1||str.length()==0){
            return str;
        }
        String longest = str.substring(0,1);
        if(str.length() == 2 && str.charAt(0) == str.charAt(1)) return str;
        if(str.length() == 2 && str.charAt(0) != str.charAt(1)) return longest;

        for(int i = 1 ; i < str.length() ; i++){

            if(str.charAt(i-1) == str.charAt(i)){
                int p1 = i-1;
                int p2 = i;
                String pal = getLongestPalindrome(str,p1,p2);
                if(pal.length() > longest.length()) longest = pal;
            }
            if(i<str.length()-1 && str.charAt(i-1) == str.charAt(i+1)){
                int p1 = i-1;
                int p2 = i+1;
                String pal = getLongestPalindrome(str,p1,p2);
                if(pal.length() > longest.length()) longest = pal;
            }
        }

        return longest;
    }

    private String getLongestPalindrome(String s, int p1, int p2) {

        while(p1>=0 && p2<s.length()){

            if(s.charAt(p1) == s.charAt(p2)){
                p1--;
                p2++;
            }
            else{
                break;
            }

        }

        return s.substring(++p1,p2);
    }


}
