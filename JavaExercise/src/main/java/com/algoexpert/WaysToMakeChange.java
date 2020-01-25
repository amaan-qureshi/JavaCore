package com.algoexpert;

public class WaysToMakeChange {


    public static void main(String[] args) {


       System.out.print(numberOfWaysToMakeChange(12,new int[]{2,3,7}));

    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.

        int ways [] = new int[n+1];
        ways[0] = 1;

        for(int coin : denoms){

            for(int i = 1; i < ways.length ; i++){

                if(coin<=i){
                    ways[i] = ways[i] + ways[i-coin];
                }

            }

        }
        return ways[n];
    }

}
