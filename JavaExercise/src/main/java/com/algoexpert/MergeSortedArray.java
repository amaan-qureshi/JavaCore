package com.algoexpert;

import java.util.*;

public class MergeSortedArray {

    public static void main(String[] args) {


        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 5, 9, 21));
        arrays.add(Arrays.asList(-1, 0));
        arrays.add(Arrays.asList(-124, 81, 121));
        arrays.add(Arrays.asList(3, 6, 12, 20, 150));


        System.out.println(mergeSortedArrays2(arrays));

    }

    public static List<Integer> mergeSortedArrays2(List<List<Integer>> arrays) {

        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int counter = 0;

        while(true) {

            boolean isAnyElementAdded = false;
            for (int i = 0; i < arrays.size(); i++) {

                if (counter < arrays.get(i).size()) {
                    heap.add(arrays.get(i).get(counter));
                    isAnyElementAdded = true;
                }
            }


            while (!heap.isEmpty()) {
                sortedList.add(heap.poll());
            }
            if(!isAnyElementAdded){
                break;
            }
            counter++;
        }

        return  sortedList;
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {

        List<Integer> idxList = new ArrayList<>(Collections.nCopies(arrays.size(),0));
        List<Integer> sortedList = new ArrayList<>();

        while(true){

           List<Items> minValItems = new ArrayList<>();

           for(int i = 0 ; i < arrays.size() ; i++) {

               if(idxList.get(i) >= arrays.get(i).size()) continue;

               minValItems.add(new Items(i,arrays.get(i).get(idxList.get(i))));
           }

           if(minValItems.size() == 0) break;

           Items minItem = getMinItem(minValItems);
           sortedList.add(minItem.element);
           idxList.set(minItem.idx,idxList.get(minItem.idx)+1);

        }

        return sortedList;
    }

    private static Items getMinItem(List<Items> minValItems) {

        Items minItems = minValItems.get(0);

        for(int i = 1; i < minValItems.size() ; i++){

            if(minItems.element > minValItems.get(i).element){
                minItems = minValItems.get(i);
            }

        }
        return minItems;
    }

    static class Items {

        int idx;
        int element;
        Items(int idx,int element){
            this.element = element;
            this.idx = idx;
        }

    }
}
