package com.algoexpert;

public class SubArraySort {

    public static void main(String[] args) { //1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
        int arr[] = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};

        int result[] = subarraySort(arr);

        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    public static int[] subarraySort(int[] array) {

        int minOutOfPlaceValue = Integer.MAX_VALUE;
        int maxOutOfPlaceValue = Integer.MIN_VALUE;

        for(int i = 0 ; i < array.length ; i++){
            if(isOutOfPlace(i,array)){
                minOutOfPlaceValue = Math.min(minOutOfPlaceValue,array[i]);
                maxOutOfPlaceValue = Math.max(maxOutOfPlaceValue,array[i]);
            }
        }

        if(minOutOfPlaceValue == Integer.MAX_VALUE || maxOutOfPlaceValue ==   Integer.MIN_VALUE)
            return new int[] {-1,-1};

        int i = 0;
        while(array[i] <= minOutOfPlaceValue){
            i++;
        }


        int j = array.length-1;
        while(array[j] >= maxOutOfPlaceValue){
            j--;
        }

        return new int[]{i,j};

    }

    public static boolean isOutOfPlace(int i,int[] arr){

        if(i == 0){
            return !(arr[i+1] >= arr[i]);
        }
        if(i == arr.length-1){
            return !(arr[i-1] < arr[i]);
        }

        return !(arr[i-1] < arr[i] && arr[i+1] >= arr[i]);
    }

}