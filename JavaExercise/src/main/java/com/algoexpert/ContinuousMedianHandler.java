package com.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContinuousMedianHandler {
    public static void main(String[] args) {
        ContinuousMedianHandler handler = new ContinuousMedianHandler();
        handler.insert(5);
        System.out.println(handler.getMedian());
        handler.insert(10);
        System.out.println(handler.getMedian());
    }

    double median = 0;

    List<Integer> array = new ArrayList<Integer>();
    int middle = 0;

    public void insert(int number) {
        // Write your code here.
        array.add(number);
        Collections.sort(array);
        middle = (array.size() - 1) / 2;

    }

    public double getMedian() {
        if (array.size() % 2 == 0) {
            return (double) ((array.get(middle) + array.get(middle + 1)) / (double)2);
        } else {
            return (double) array.get(array.size() / 2);
        }
    }
}
