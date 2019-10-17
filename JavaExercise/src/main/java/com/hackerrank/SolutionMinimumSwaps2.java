package com.hackerrank;

public class SolutionMinimumSwaps2 {

    static int minimumSwaps(int[] arr) {

        int swaps = 0;

        for(int i = 0 ; i < arr.length ; i++){

            if(arr[i] == i + 1) {
                continue;
            }
            else{

              int index = arr[i] - 1;

              while( (arr[index] != index+1)  ){
                  index = arr[index] - 1;
              }

              swap(arr,i,index);
              swaps++;
            }
        }


        return swaps;
    }

    private static void swap(int[] arr, int i, int index) {

        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;

    }

    public static void main(String[] args) {

        int [] arr = {2, 3, 4, 1, 5};
        System.out.println(minimumSwaps(arr));
    }
}
