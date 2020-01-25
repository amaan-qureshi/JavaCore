package com.hackerrank.array;

public class Test {

    public static void main(String[] args) {


        minimumBribes(new int[]{2,1,5,3,4});

    }

    static void minimumBribes(int[] q) {

        int count = 0;
        for(int i = q.length-1 ; i >= 0 ; i-- ){

            if(q[i] == i+1)continue;

            else if(q[i-1] == i+1){
                count++;
                int temp = q[i - 1];
                q[i - 1] = q[i];
                q[i] = temp;
                continue;
            }

            else if(q[i-2] == i+1){
                count+=2;
                int temp = q[i - 2];
                q[i - 2] = q[i - 1];
                q[i - 1] = q[i];
                q[i] = temp;
                continue;
            }

            else{
                System.out.println("Too chaotic");
                return;
            }

        }
        System.out.println(count);

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
