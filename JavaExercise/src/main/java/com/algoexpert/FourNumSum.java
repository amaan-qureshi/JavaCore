package com.algoexpert;

import java.util.*;

public class FourNumSum {

    public static void main(String[] args) {

        List<Integer[]> l = fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);

        for(Integer[] i : l) {
            System.out.println(i[0]+" , "+i[1]+" , "+i[2]+" , "+i[3]);
        }
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i = 1; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                int difference = targetSum - sum;
                if(map.containsKey(difference)) {
                    for(Integer[] pair: map.get(difference)){
                        result.add(new Integer[]{pair[0],pair[1],array[i],array[j]});
                    }
                }

            }

            for (int k = 0; k < i; k++) {

                int sum = array[k] + array[i];
                if (!map.containsKey(sum)){
                    List<Integer[]> l = new ArrayList<>();
                    l.add(new Integer[]{array[k],array[i]});
                    map.put(sum,l);
                }
                else{
                    map.get(sum).add(new Integer[]{array[k],array[i]});
                }
            }

        }


        // Write your code here.
        return result;
    }


}
