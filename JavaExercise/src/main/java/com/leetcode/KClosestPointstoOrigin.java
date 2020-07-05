package com.leetcode;

import java.util.*;

public class KClosestPointstoOrigin {

    public static void main(String[] args) {

        int[][] i = {{0, 1}, {1, 0}};
        kClosest(i, 2);

    }

    public static int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Double, List<Integer[]>> map = new HashMap<>();
        int size = 0;

        for (int[] i : points) {
            Double distance = Math.sqrt(i[0] * i[0] + i[1] * i[1]);
            Integer[] point = new Integer[2];
            point[0] = i[0];
            point[1] = i[1];

            if (map.containsKey(distance)) {
                map.get(distance).add(point);
            } else {
                List<Integer[]> l = new ArrayList<>();
                l.add(point);
                map.put(distance, l);
            }


            pq.add(distance);
            if (size == K) {
                pq.remove();
            } else {
                size++;
            }
        }

        int[][] result = new int[pq.size()][];
        int i = 0;
        while (!pq.isEmpty() && i < result.length) {
            List<Integer[]> l = map.get(pq.remove());

            for (Integer[] res : l) {
                result[i] = new int[]{res[0], res[1]};
                i++;
            }
        }

        return result;


    }

}
