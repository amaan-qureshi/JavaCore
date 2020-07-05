package com.algoexpert;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {


    public static void main(String[] args) {

        List<Integer> s1 = Arrays.asList(1,1,6,1);
        List<Integer> s2 = Arrays.asList(1,1,1,6);
        System.out.println(isValidSubsequence(s1,s2));

    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        if(sequence.size()>array.size()) return  false;

        int p1 = 0;
        int p2 = 0;

        while(p1 < array.size() && p2 < sequence.size()){

            if(sequence.get(p2) == array.get(p1)){
                p1++;
                p2++;
            }
            else{
                p1++;
            }
        }

        return p2 == sequence.size();
    }

}
