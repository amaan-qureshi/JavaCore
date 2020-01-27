package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {

        System.out.print(powerset(new int[]{1,2,3}));

    }


    public static List<List<Integer>> powerset(int[] array){

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(Integer e : array){
            int size = result.size();

            for(int i = 0 ; i < size ; i++){

                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(e);
                result.add(subset);
            }

        }

        return result;
    }
}
