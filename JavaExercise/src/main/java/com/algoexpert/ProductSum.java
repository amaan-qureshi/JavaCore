package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

class ProductSum {

    public static void main(String[] args) {

        ArrayList<Object> test = new ArrayList<Object>(Arrays.asList(1, 2, new ArrayList<Object>(Arrays.asList(3, 4, new ArrayList<Object>(Arrays.asList(3, 4, new ArrayList<Object>(Arrays.asList(3, 4)))))), 4, 5));
        System.out.println(productSum(test));
    }

    public static int productSum(ArrayList<Object> array) {
        return productSum(array, 1);
    }

    public static int productSum(ArrayList<Object> array, int multiplier) {

        int sum = 0;
        for (Object a : array) {

            if (a instanceof Integer)
                sum += (Integer) a;
            else if (a instanceof ArrayList) {
                multiplier++;
                sum += productSum((ArrayList) a, multiplier);
            }
        }

        return sum * multiplier;
    }
}
