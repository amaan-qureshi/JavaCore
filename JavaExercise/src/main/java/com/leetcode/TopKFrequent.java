package com.leetcode;
import java.util.*;

public class TopKFrequent {

    void print(int[] res){
        Arrays.stream(res).forEach(i -> System.out.print(i+" "));
        System.out.println();
    }

    public static void main(String[] args) {

        TopKFrequent o = new TopKFrequent();
        int[] res = o.topKFrequent(new int[]{1,1,1,2,2,3},2);
        o.print(res);
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[][] arr = {{}};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> uniqueKeys = new ArrayList<>();

        for (int n : nums) {
            Integer i = freq.get(n);
            if (null == i) {
                freq.put(n, 1);
                uniqueKeys.add(n);
            } else {
                freq.put(n, i + 1);
            }
        }

        return topFrequencyCalculatorUsingQuickSelect(uniqueKeys, freq, k);
    }

    int[] topFrequencyCalculatorUsingQuickSelect(List<Integer> uniqueKeys, Map<Integer, Integer> freq, int k) {

        int start = 0;
        int end = uniqueKeys.size() - 1;
        int position = uniqueKeys.size() - k;

        while (true) {

            int pivot = start;
            int left = start + 1;
            int right = end;


            while (right > left) {

                if (freq.get(uniqueKeys.get(left)) > freq.get(uniqueKeys.get(pivot)) && freq.get(uniqueKeys.get(right)) < freq.get(uniqueKeys.get(pivot))) {
                    swap(uniqueKeys, left, right);
                }

                if (freq.get(uniqueKeys.get(left)) <= freq.get(uniqueKeys.get(pivot))) {
                    left++;
                }

                if (freq.get(uniqueKeys.get(right)) >= freq.get(uniqueKeys.get(pivot))) {
                    right--;
                }
            }

            swap(uniqueKeys, left, right);
            if (right == position) {
                int[] res = new int[k];
                int c = position;
                int arrC = 0;
                while (c < uniqueKeys.size()) {
                    res[arrC] = uniqueKeys.get(c);
                    arrC++;
                    c++;
                }
                return res;

            }
            if (position > right) {
                start = right + 1;
            } else {
                end = right - 1;
            }
        }

    }

    void swap(List<Integer> uniqueKeys, int left, int right) {


        int temp = uniqueKeys.get(left);
        uniqueKeys.set(left, uniqueKeys.get(right));
        uniqueKeys.set(right, temp);
    }


}
