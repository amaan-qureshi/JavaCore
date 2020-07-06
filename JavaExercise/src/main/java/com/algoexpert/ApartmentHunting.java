package com.algoexpert;
import java.util.*;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        List<List<Integer>> distances = new ArrayList<>();




        int idealBlock = 0;
        int maxDis = Integer.MAX_VALUE;

        for(int i = 0 ; i < blocks.size() ; i++){

            List<Integer> totalWalks = new ArrayList<>();
            for(int j = 0 ; j < distances.size() ; j++){
                totalWalks.add(distances.get(j).get(i));
            }
            Collections.sort(totalWalks);

            int currentDistance = totalWalks.get(totalWalks.size()-1);
            if(currentDistance<maxDis){
                maxDis = currentDistance;
                idealBlock = i;
            }

        }

        return idealBlock;
    }

}
