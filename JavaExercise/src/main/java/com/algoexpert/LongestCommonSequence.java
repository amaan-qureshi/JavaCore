package com.algoexpert;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSequence {

    public static void main(String[] args) {

        longestCommonSubsequence("ZXVVYZW", "XKYKZPW").forEach(c -> System.out.print((char)c+" "));
    }


    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.

        String[][] array = new String[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < array.length; i++) {
            array[i][0] = "";
        }
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = "";
        }

        for (int i = 1; i < array.length; i++) {

            for (int j = 1; j < array[0].length; j++) {


                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    array[i][j] = ""+array[i-1][j-1]+str1.charAt(i-1);
                }
                else{
                    array[i][j] = array[i][j-1].length() > array[i-1][j].length() ? array[i][j-1] : array[i-1][j];
                }

            }

        }

        return array[array.length-1][array[0].length-1].chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }


}
