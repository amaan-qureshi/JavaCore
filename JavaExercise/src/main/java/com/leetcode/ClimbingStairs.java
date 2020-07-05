package com.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {

        int[] ways = new int[n+1];
        ways[0] = 1;


        for(int i = 1 ; i < ways.length ; i++){

            if(1<=i){
                ways[i] = ways[i]+ways[i-1];
            }


        }


        for(int i = 2 ; i < ways.length ; i++){



            if(2<=i){
                ways[i] = ways[i]+ways[i-2];
            }

        }


        return ways[n];
    }

}
