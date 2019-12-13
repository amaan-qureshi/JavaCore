package com.algoexpert;

import java.util.HashSet;
import java.util.Set;

class TwoSum {

    public static void main(String[] args) {

        int [] arr = {3,5,-4,8,11,1,-1,6};
        int[] res = twoNumberSum(arr,10);
        System.out.print(res[0]+"  "+res[1]);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Set<Integer> set = new HashSet<Integer>();
        int[] res = new int[2];

        for (Integer a : array) {

            int diff = targetSum - a;
            if (set.contains(a)) {

                if (a > diff) {
                    res[0] = diff;
                } else {
                    res[1] = a;
                }
                break;
            } else {
                set.add(diff);
            }

        }

        return res;
    }
}