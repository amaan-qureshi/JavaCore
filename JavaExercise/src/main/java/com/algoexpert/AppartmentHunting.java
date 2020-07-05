package com.algoexpert;

import java.util.*;

public class AppartmentHunting {

    public static void main(String[] args) {

        String[] arr = {"gym","school","store"};
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String,Boolean> block1 = new HashMap<>();
        block1.put("gym",false);
        block1.put("school",true);
        block1.put("store",false);
        Map<String,Boolean> block2 = new HashMap<>();
        block2.put("gym",true);
        block2.put("school",false);
        block2.put("store",false);
        Map<String,Boolean> block3 = new HashMap<>();
        block3.put("gym",true);
        block3.put("school",true);
        block3.put("store",false);
        Map<String,Boolean> block4 = new HashMap<>();
        block4.put("gym",false);
        block4.put("school",true);
        block4.put("store",false);
        Map<String,Boolean> block5 = new HashMap<>();
        block5.put("gym",false);
        block5.put("school",true);
        block5.put("store",true);

        blocks.add(block1);blocks.add(block2);blocks.add(block3);blocks.add(block4);blocks.add(block5);
        apartmentHunting(blocks,arr);
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.

        List<List<Integer>> distances = new ArrayList<>();

        for (String req : reqs) {

            List<Integer> distance = new ArrayList<>();
            int lastFoundAt = Integer.MAX_VALUE;

            for (int i = 0; i < blocks.size(); i++) {
                if (blocks.get(i).get(req)) {
                    lastFoundAt = i;
                    distance.add(0);
                } else {
                    if (lastFoundAt == Integer.MAX_VALUE) {
                        distance.add(lastFoundAt);
                    } else {
                        distance.add(Math.abs(i - lastFoundAt));
                    }
                }
            }

            lastFoundAt = Integer.MAX_VALUE;
            for (int i = blocks.size() - 1; i >= 0; i--) {

                if (!blocks.get(i).get(req)) {
                    if (lastFoundAt != Integer.MAX_VALUE) {
                        distance.set(i, Math.min(distance.get(i), Math.abs(lastFoundAt - i)));
                    }
                } else {
                    lastFoundAt = i;
                }

            }

            distances.add(distance);
        }

        int [] maxDistanceAtBlock = new int[blocks.size()];
        for(int i = 0 ; i < blocks.size() ; i ++){

            int currentDistance = Integer.MIN_VALUE;

            for(int j = 0 ; j < distances.size() ; j ++){
                currentDistance = Math.max(distances.get(j).get(i),currentDistance);
            }

            maxDistanceAtBlock[i] = currentDistance;

        }

        return -1;
    }
}