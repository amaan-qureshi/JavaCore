package com.leetcode;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(new SearchInRotatedArray().search(arr,0));
    }
    public int search(int[] nums, int target) {

        if(nums==null || nums.length==0) return -1;
        if(nums.length==1 && nums[0] == target) return 0;
        if(nums.length==1 && nums[0] != target) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start<=end){

            int middle = (start+end) / 2;

            if(target == nums[middle]) return middle;
           // if(middle == start || middle == end) break;
            if(target > nums[middle]){

                if(target > nums[end] && target <= nums[start]){
                    end = middle-1;
                }
                else{
                    start = middle+1;
                }

            }
            else{

                if(target < nums[start] && target <=nums[end]){
                    start = middle+1;
                }
                else{
                    end = middle-1;
                }

            }

        }

        return -1;
    }
}
