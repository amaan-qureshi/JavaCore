package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementsToEnd {

    public static void main(String[] args) {

        List<Integer> n = new ArrayList<>(Arrays.asList(3,1,2,4,5 ));
        System.out.println(moveElementToEnd(n,3));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.

        int p1 = 0;
        int p2 = array.size()-1;

        while(p1<p2){

            if(array.get(p1) == toMove){

                while(array.get(p2) == toMove && p2>p1){
                    p2--;
                }


                int temp = array.get(p2);
                array.set(p2,array.get(p1));
                array.set(p1,temp);

            }
            p1++;

        }

        return array;
    }

    public static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
