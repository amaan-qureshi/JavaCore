package com.leetcode;

public class MaxWaterContainer {

    public static void main(String[] args) {

        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {

        int max = 0;
        int p1 = 0;
        int p2 = height.length-1;

        while(p1 > p2){

            max = Math.max(max,Math.min(height[p1],height[p2]) * (p2-p1));

            if(height[p1] > height[p2]){
                p2--;
            }
            else{
                p1++;
            }

        }

        return max;

    }
}
