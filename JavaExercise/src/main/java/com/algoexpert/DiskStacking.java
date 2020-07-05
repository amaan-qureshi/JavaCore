package com.algoexpert;

import java.util.*;

public class DiskStacking {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {

        disks.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2].compareTo(o2[2]);
            }
        });

        int[] heights = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }

        int[] topDisk = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            topDisk[i] = Integer.MIN_VALUE;
        }

        int maxHeightLocation = 0;
        for (int i = 1; i < disks.size(); i++) {

            Integer[] currentDisk = disks.get(i);

            for (int j = 0; j < i; j++) {

                Integer[] otherDisk = disks.get(j);

                if (otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2]) {

                    if (heights[i] <= heights[j] + currentDisk[2]) {
                        heights[i] = heights[j] + currentDisk[2];
                        topDisk[i] = j;
                    }
                }
            }
            if (heights[i] >= maxHeightLocation) {
                maxHeightLocation = i;
            }

        }

        List<Integer[]> result = new ArrayList<>();
        int currentIndex = maxHeightLocation;

        while (currentIndex != Integer.MIN_VALUE) {

            result.add(0, disks.get(currentIndex));
            currentIndex = topDisk[currentIndex];

        }


        return result;
    }


}
