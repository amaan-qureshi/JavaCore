package com.hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionNewYearChaos {


    static void minimumBribes(int[] q) {


        int bribes = 0;
        boolean chaotic = false;

        for (int i = q.length - 1; i >= 0; i--) {


            if (q[i] == i+1)
                continue;

            if (q[i - 1] == i+1) {

                bribes++;

                int temp = q[i - 1];
                q[i - 1] = q[i];
                q[i] = temp;

            } else if (q[i - 2] == i+1) {

                bribes += 2;

                int temp = q[i - 2];
                q[i - 2] = q[i - 1];
                q[i - 1] = q[i];
                q[i] = temp;

            } else {
                chaotic = true;
                break;
            }


        }


        if (chaotic) {
            System.out.print("Too Chaotic");
        } else {
            System.out.print(bribes);
        }


    }


    public static void main(String[] args) {

        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(q);

    }
}
