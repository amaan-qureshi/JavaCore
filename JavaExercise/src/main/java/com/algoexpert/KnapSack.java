package com.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapSack {

    public static void main(String[] args) {

        int m[][] = {
                {465, 100},
                {400, 85},
                {255, 55},
                {350, 45},
                {650, 130},
                {1000, 190},
                {455, 100},
                {100, 25},
                {1200, 190},
                {320, 65},
                {750, 100},
                {50, 45},
                {550, 65},
                {100, 50},
                {600, 70},
                {240, 40}};

        System.out.println(knapsackProblem(m, 200));
    }


    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

        // Write your code here.

        int[][] knapsackValues = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < items.length + 1; i++) {

            int currentWeight = items[i - 1][1];
            int currentValue = items[i - 1][0];

            for (int c = 0; c < capacity + 1; c++) {

                if (currentWeight > c) {

                    knapsackValues[i][c] = knapsackValues[i - 1][c];

                } else {
                    knapsackValues[i][c] = Math.max(knapsackValues[i - 1][c], currentValue + knapsackValues[i - 1][c - currentWeight]);
                }
            }

        }

        //System.out.println(knapsackValues[items.length][capacity]);

        List<Integer> selectedItems = new ArrayList<>();

        int i = knapsackValues.length-1;
        int c = knapsackValues[0].length-1;

        while(i>0){

            if(knapsackValues[i][c] == knapsackValues[i-1][c]){
                i--;

            }
            else{
                selectedItems.add(i-1);
                c-= items[i-1][1];
                i--;

            }
            if(c==0)break;

        }
        //System.out.println(selectedItems);
        List<List<Integer>> results = new ArrayList<>();
        results.add(Collections.singletonList(knapsackValues[items.length][capacity]));

        results.add(selectedItems);

        return results;
    }


}
