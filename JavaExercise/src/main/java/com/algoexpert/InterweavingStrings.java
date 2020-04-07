package com.algoexpert;

import java.util.*;

public class InterweavingStrings {

    public static void main(String[] args) {
        System.out.println(interweavingStrings("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean interweavingStrings(String one, String two, String three) {


        if(three.length()!=one.length()+two.length()){
            return false;
        }

        int i = 0;
        int j = 0;


        while(i<one.length() || j < two.length()){

            int k = i+j;

            if(i<one.length() && one.charAt(i) == three.charAt(k)){
                i++;
            }
            if(j<two.length() && two.charAt(j) == three.charAt(k)){
                j++;
            }
            else{
                return false;
            }
        }

        return i == one.length() && j == two.length();
    }

   /* public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        Map<Character,Integer> cache = new HashMap<>();

        for(Character c : one.toCharArray()){
            if(cache.containsKey(c)){
                int i = cache.get(c);
                cache.put(c,++i);
            }
            else{
                cache.put(c,1);
            }
        }
        for(Character c : two.toCharArray()){
            if(cache.containsKey(c)){
                int i = cache.get(c);
                cache.put(c,++i);
            }
            else{
                cache.put(c,1);
            }
        }

        for(Character c : three.toCharArray()){

            if(cache.containsKey(c) && cache.get(c) > 0){
                int i = cache.get(c);
                cache.put(c,--i);
            }
            else{
                return false;
            }
        }

        return true;

    }
*/
}
