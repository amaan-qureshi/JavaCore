package com.core.structure;

import java.util.Arrays;
import java.util.stream.Collectors;

class CheckConvert {

    public static void main(String[] args) {

        int[] arr = {9,4,7,1,-2,6,5};
        System.out.print(convertMax(arr));
    }

    public static String convertMax(int[] maxHeap) {

        String result = "";

        int size = maxHeap.length;

        for (int i = (size - 1) / 2; i >= 0; i--) {

            minHeapify(maxHeap, i, size);

        }

        System.out.println(Arrays.asList(maxHeap).stream().map(String::valueOf).collect(Collectors.joining(",")));
        // Write - Your - Code
        return "[" + Arrays.asList(maxHeap).stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }

    public static void minHeapify(int[] arr, int index, int size) {

        int smallest = index;

        while (smallest < size / 2) {

            int left = 2 * index + 1;
            int right = 2 * index + 1;

            if (left < size && arr[left] < arr[index]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[index]) {
                smallest = right;
            }

            if (index != smallest) {

                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            } else {
                break;
            }

        }

    }


}