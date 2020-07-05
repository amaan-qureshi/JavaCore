package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray2 {

    public static void main(String[] args) {


        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 5, 9, 21));
        arrays.add(Arrays.asList(-1, 0));
        arrays.add(Arrays.asList(-124, 81, 121));
        arrays.add(Arrays.asList(3, 6, 12, 20, 150));


        System.out.println(mergeSortedArrays(arrays));

    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {

        List<Integer> sortedList = new ArrayList<>();
        List<Item> smallestItems = new ArrayList<>();
        int c = 0;
        for(List<Integer> array : arrays){
            smallestItems.add(new Item(c++,0,array.get(0)));
        }

       // MinHeap heap = new MinHeap(smallestItems);
/*
        while(!heap.isEmpty()){

            Item minItem = heap.getMin();
            sortedList.add(minItem.element);
            if(minItem.eleIdx+1 >= arrays.get(minItem.arrIdx).size()) continue;
            heap.add(new Item(minItem.arrIdx,minItem.eleIdx+1,arrays.get(minItem.arrIdx).get(minItem.eleIdx+1)));

        }*/

        return  sortedList;
    }

    static class Item {

        int arrIdx;
        int eleIdx;
        int element;
        Item(int arrIdx,int eleIdx,int element){
            this.element = element;
            this.arrIdx = arrIdx;
            this.eleIdx = eleIdx;
        }

    }


    private static class MinHeap {
    }
}
