package com.algoexpert;

class BubbleSort {
    public static int[] bubbleSort(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }


            }

            if (!swapped) {
                break;
            }


        }

        return array;
    }
}
