package com.leetcode;

public class JumpGame {

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2,3,1,1,4}));

    }

    public static boolean canJump(int[] nums) {

        if(nums.length == 1){
            return nums[0] > 0;
        }

        boolean[] reachable = new boolean[nums.length];


        for(int i = 0 ; i < nums.length ;i++){

            int c = i;

            while(c <= nums[i] && c < nums.length-1){
                reachable[c++] = true;
            }


        }


        return reachable[nums.length-1];
    }

}
