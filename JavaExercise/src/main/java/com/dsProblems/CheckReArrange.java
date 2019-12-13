package com.dsProblems;

import java.util.Arrays;

public class CheckReArrange {


    public static void main(String[] args) {

        int[] arr = {10,-1,20,4,5,-9,-6};
        reArrange(arr);
       Arrays.stream(arr).forEach(System.out::print);
    }

    public static void reArrange(int[] arr) {

        int p1 = 0;
        int p2 = arr.length - 1;


        while(p1!=p2){

         if(arr[p1]<0){
             p1++;
             continue;
         }
         if(arr[p2]>0){
             p2--;
             continue;
         }

         int t = arr[p1];
         arr[p1] = arr[p2];
         arr[p2] = t;
         p1++;
         p2--;
        }
    }

}
