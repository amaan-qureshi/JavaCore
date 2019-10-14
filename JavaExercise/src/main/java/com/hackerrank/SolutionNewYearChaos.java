package com.hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionNewYearChaos {

    static void minimumBribes(int[] q) {

        int[] sorted = q.clone();
        Arrays.sort(sorted);

        Map<Integer,Integer> intPositionMap = new HashMap<>();
        int count = 0;
        for(int i : sorted){
            intPositionMap.put(i,count);
            count++;
        }
        boolean chaotic = false;
        int bribes = 0;
        for(int i = 0 ; i < q.length ; i++){

            if(intPositionMap.get(q[i]) - 2 <=  i){

                if(intPositionMap.get(q[i]) != i){
                    if(intPositionMap.get(q[i]) - 1 == i){
                        bribes++;
                    }
                    else if (intPositionMap.get(q[i]) - 2 == i){
                        bribes++;
                        bribes++;
                    }
                }

            }
            else{
                chaotic = true;
                break;
            }

        }

        if(chaotic){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(bribes);
        }
    }

    public static void main(String[] args) {

        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        minimumBribes(q);

    }
}
