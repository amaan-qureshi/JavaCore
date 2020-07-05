package com.leetcode;

public class CircularRobbery {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,3,2}));

    }

    public static int rob(int[] nums) {



        if(nums == null || nums.length == 0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];


        int[] houses = new int[nums.length];
        houses[0] = nums[0];
        houses[1] = Math.max(nums[1],nums[0]);

        boolean isFirstRobbed = nums[0] > nums[1];
        boolean isLastRobbed = false;

        for(int i = 2 ; i < nums.length ; i++){


            if(houses[i-1] > nums[i]+houses[i-2]){
                houses[i] = houses[i-1];
                isLastRobbed = false;
            }
            else{
                houses[i] = nums[i]+houses[i-2];
                isLastRobbed = true;
            }

        }

        if(isFirstRobbed != isLastRobbed){
            return houses[nums.length-1];
        }
        else{
            return houses[nums.length-2];
        }
    }

}
