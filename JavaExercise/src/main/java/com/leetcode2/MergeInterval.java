package com.leetcode2;
import java.util.*;

public class MergeInterval {

    public static void main(String[] args) {

        insert(new int[][]{{0,5},{9,12}},new int[]{7,16});

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) return intervals;

        List<int[]> result = new ArrayList<>();

        int i = 0;
        for (int[] interval : intervals) {
            if (interval[0] < newInterval[0]) {
                result.add(interval);
            } else {
                break;
            }
            i++;
        }

        if (result.size() == 0) {
            result.add(newInterval);
        }

        int[] prev = result.get(result.size() - 1);

        if (prev[1] < newInterval[0]) {
            result.add(newInterval);
        } else if (prev[1] <= newInterval[1]) {
            prev[1] = newInterval[1];
        }

        for (int j = i; j < intervals.length; j++) {

            if ( prev[1] < intervals[j][0]) {
                result.add(intervals[j]);
                prev = intervals[j];
            }
            else if(intervals[j][0] >= prev[0] && intervals[j][1] > prev[1] ){
                prev[1] = intervals[j][1];
            }


        }


        int[][] resPrim = new int[result.size()][];
        return result.toArray(resPrim);

    }
}
