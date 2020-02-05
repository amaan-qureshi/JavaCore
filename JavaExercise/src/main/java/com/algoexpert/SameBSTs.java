package com.algoexpert;

import java.util.*;

public class SameBSTs {
    public static void main(String[] args) {
        System.out.println(sameBsts(Arrays.asList(10,15,8,12,94,81,5,2,11),Arrays.asList(10,8,5,15,2,12,11,94,81)));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if(arrayOne.size()!=arrayTwo.size()) return false;

        if(arrayOne.size()==0 && arrayTwo.size()==0) return true;

        if(arrayOne.get(0)!=arrayTwo.get(0)) return false;

        List<Integer> allSmallerThanRootOne = getAllSmaller(arrayOne);
        List<Integer> allSmallerThanRootTwo = getAllSmaller(arrayTwo);
        List<Integer> allLargerThanRootOne = getAllLarger(arrayOne);
        List<Integer> allLargerThanRootTwo = getAllLarger(arrayTwo);

        return sameBsts(allSmallerThanRootOne,allSmallerThanRootTwo) && sameBsts(allLargerThanRootOne,allLargerThanRootTwo);
    }

    public static List<Integer> getAllSmaller(List<Integer> array){

        List<Integer> result = new ArrayList<Integer>();
        int root = array.get(0);

        for(int i = 1 ; i < array.size() ; i ++){
            if(array.get(i) < root){
                result.add(array.get(i));
            }
        }

        return result;
    }

    public static List<Integer> getAllLarger(List<Integer> array){

        List<Integer> result = new ArrayList<Integer>();
        int root = array.get(0);

        for(int i = 1 ; i < array.size() ; i ++){
            if(array.get(i) >= root){
                result.add(array.get(i));
            }
        }

        return result;

    }
}
