package com.algoexpert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.*;

public class LargestRange {

    public static void main(String[] args) {

        /*int[] r = largestRange(new int[]{19,-1,18,17,2,10,3,12,5,16,4,11,8,7,6,15,12,12,2,1,6,13,14});*/
        int[] r = largestRange(new int[]{1,11,3,0,15,5,2,4,10,7,12,6});
        System.out.println(r[0]+" "+r[1]);

    }

    public static int[] largestRange(int[] array) {


        Map<Integer,Boolean> map = new HashMap<>();
        for(int i : array){
            map.put(i,true);
        }

        int longest = 0;
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < array.length ; i++){

            int s = array[i];
            int currentLength = 1;
            int currentStart = s;
            int currentEnd = s;
            map.put(s,false);

            while(map.containsKey(s-1) && map.get(s-1)){
                s = s-1;
                map.put(s,false);
                currentLength++;
            }
            currentStart = s;

            s = array[i];

            while(map.containsKey(s+1) && map.get(s+1)){
                s = s+1;
                map.put(s,false);
                currentLength++;
            }
            currentEnd = s;

            if(currentLength>longest){
                start = currentStart;
                end= currentEnd;
                longest= currentLength;
            }

        }


        return new int[]{start,end};
    }

    public static int[] largestRange2(int[] array) {
        // Write your code here.

        Arrays.sort(array);
        int start = 0;
        int end = 0;
        int max = 1;

        for(int i = 0 ; i < array.length ; i++){

            int p = i;
            int length = 1;
            while(p+1<array.length && array[p]+1 == array[p+1]){
                length++;
                p++;
            }

            if(length > max){
                max = length;
                start = array[i];
                end = array[p];
                i=p;
            }
        }

        return new int[]{start,end};
    }

}
