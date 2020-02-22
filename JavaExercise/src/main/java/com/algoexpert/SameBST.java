package com.algoexpert;

import java.util.*;

public class SameBST {

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(10,15,8,12,94,81,5,2,-1,100,45,12,8,-1,8,2,-34);
        List<Integer> b = Arrays.asList(10,8,5,15,2,12,94,81,-1,-1,-34,8,2,8,12,45,100);

        System.out.println(sameBsts(a, b));
    }

    //10 , 8 , 5 , 2 , 15 , 12 , 11 , 94 , 81
    //10 , 8 ,5 ,2 , 15 , 12 ,11 ,94, 81

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.

        if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0)) return false;

        List<Integer> orderOne = getOrderedList(arrayOne);
        List<Integer> orderTwo = getOrderedList(arrayTwo);
        return orderOne.equals(orderTwo);
    }

    public static List<Integer> getOrderedList(List<Integer> arrayOne) {


        List<Integer> orderOne = new ArrayList<>();
        orderOne.add(arrayOne.get(0));
        boolean[] visited = new boolean[arrayOne.size()];
        visited[0] = true;
        int toCompare = orderOne.get(0);

        while (arrayOne.size() != orderOne.size()) {
            for (int i = 1; i < arrayOne.size(); i++) {

                if (!visited[i] && arrayOne.get(i) <= toCompare) {
                    visited[i] = true;
                    orderOne.add(arrayOne.get(i));
                    toCompare = arrayOne.get(i);
                }
            }

            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    toCompare = arrayOne.get(i);
                    orderOne.add(toCompare);
                    visited[i] = true;
                    break;
                }

            }
        }

        return orderOne;
    }
}
