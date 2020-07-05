package com;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {

        System.out.println(isAnagram("a","b"));
       // int[] arr = {}

    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character,Integer> charMap = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){

            Character c = s.charAt(i);
            int freq = charMap.getOrDefault(c,0);
            charMap.put(c,freq+1);

            Character c2 = s.charAt(i);
            int freq2 = charMap.getOrDefault(c2,0);
            charMap.put(c2,freq2-1);
        }

        for(Character key : charMap.keySet()){

            if(charMap.get(key) != 0){
                return false;
            }
        }

        return true;

    }


}
