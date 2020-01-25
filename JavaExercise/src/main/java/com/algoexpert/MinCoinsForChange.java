package com.algoexpert;

import java.util.Arrays;

public class MinCoinsForChange {

    public static void main(String[] args) {

        System.out.println(minNumberOfCoinsForChange(3,new int[]{2,1}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.

        int amounts[] = new int[n+1];
        Arrays.fill(amounts,Integer.MAX_VALUE);
        amounts[0] = 0;
        int maxCurrent = 0;

        for(Integer denom : denoms){

            for(int amount = 0 ; amount < amounts.length ; amount++){

                if(denom<=amount){

                    if(amounts[amount-denom] == Integer.MAX_VALUE){
                        maxCurrent = Integer.MAX_VALUE;
                    }
                    else{
                        maxCurrent = amounts[amount-denom]+1;
                    }
                    amounts[amount] = Math.min(maxCurrent,amounts[amount]);
                }
            }

        }
        return amounts[n] == Integer.MAX_VALUE ? -1 : amounts[n] ;
    }
}
