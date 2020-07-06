package com.leetcode2;

import java.util.Arrays;

public class HouseRobber2 {



    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int arr1[] = Arrays.copyOfRange(nums,0,nums.length-1);
        int arr2[] = Arrays.copyOfRange(nums,1,nums.length);

        return Math.max(robSingle(arr1),robSingle(arr2));
    }

    public int robSingle(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int max[] = new int[nums.length+1];
        max[1] = nums[0];
        max[2] = Math.max(nums[0],nums[1]);

        for(int i = 3 ; i < max.length ; i++){

            max[i] = Math.max(nums[i-1]+max[i-2],max[i-1]);

        }

        return max[max.length-1];

    }
}
