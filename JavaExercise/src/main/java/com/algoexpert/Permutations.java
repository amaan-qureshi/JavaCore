package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        System.out.print(getPermutations(Arrays.asList(1,2,3)));

    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations =  new ArrayList<List<Integer>>();
        permutations(array,new ArrayList<Integer>(),permutations);
        return permutations;
    }

    private static void permutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {

            if(array.size() == 0 && currentPermutation.size() > 0){
                permutations.add(currentPermutation);
                return;
            }

            for(int i=0 ; i < array.size() ; i++){

                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                permutations(newArray,newPermutation,permutations);
            }

    }

}
