package com.algoexpert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {

    public static void main(String[] args) {

        System.out.println(minRewards(new int[]{0,4,2,1,3}));
    }

    public static int minRewards(int[] scores) {

        int rewards[] = new int[scores.length];

        String[] arr = {"a","b"};

        Arrays.fill(rewards, 1);

        int minIndex = findMin(scores);

        int index1 = minIndex;
        int index2 = minIndex;

        while (index1-1 >= 0) {


            int prev = index1 - 1;
            if (scores[prev] >= scores[index1]) {
                rewards[prev] = rewards[index1] + 1;
            } else {
                rewards[prev] = 1;
            }

            index1--;

        }

        while (index2+1 < scores.length) {

            int next = index2 + 1;
            if (scores[next] >= scores[index2]) {
                rewards[next] = rewards[index2] + 1;
            } else {
                rewards[next] = 1;
            }

            index2++;

        }


        return IntStream.of(rewards).sum();
    }

    private static int findMin(int[] scores) {

        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < min) {
                index = i;
                min = scores[i];
            }
        }
        return index;
    }

}
