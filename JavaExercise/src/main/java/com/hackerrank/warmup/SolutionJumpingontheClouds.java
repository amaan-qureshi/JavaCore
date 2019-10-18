package com.hackerrank.warmup;

public class SolutionJumpingontheClouds {

    static int jumpingOnClouds(int[] c) {

        int currentLocation = 0;
        int jumps = 0;

        while(currentLocation<c.length-1){

            if(currentLocation+2<c.length && c[currentLocation+2]!=1){

                jumps++;
                currentLocation += 2;

            }
            else if (currentLocation+1<c.length && c[currentLocation+1]!=1){

                jumps++;
                currentLocation ++;

            }


        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] arr = {0, 0, 0, 1, 0, 0};
        System.out.print(jumpingOnClouds(arr));
    }

}
