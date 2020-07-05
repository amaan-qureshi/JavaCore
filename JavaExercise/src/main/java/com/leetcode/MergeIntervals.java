package com.leetcode;
import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals m = new MergeIntervals();

        int[][] res = m.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
        System.out.println();

    }

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {

            if(o1[0] != o2[0]){
                return Integer.compare(o1[0],o2[0]);
            }
            else{
                return Integer.compare(o1[1],o2[1]);
            }

        });
        result.add(intervals[0]);

        for(int i = 1 ; i < intervals.length ; i++){

            int[] prev = result.get(result.size()-1);
            int[] curr =  intervals[i];

            if(prev[1] < curr[0]){
                result.add(curr);
            }

            else if(curr[0] > prev[0] && curr[1] > prev[1] ){
                prev[1] = curr[1];
            }

        }

        int[][] resPrim = new int[result.size()][];
        return result.toArray(resPrim);

    }
}
