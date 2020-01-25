package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.parser.TokenType.CASE;

public class Solution {

    static void updateFrequency( Map<Integer,Integer> frequencyMap, Integer oldFrequency,int newFrequency){

        Integer newFrequencyFrequency = frequencyMap.get(newFrequency);
        if(newFrequencyFrequency == null){
            frequencyMap.put(newFrequency,1);
        }
        else{
            frequencyMap.put(newFrequency,newFrequencyFrequency+1);
        }

        if(oldFrequency !=null)
            frequencyMap.put(oldFrequency,frequencyMap.get(oldFrequency)-1);
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(List<Integer> query : queries){

            int type = query.get(0);
            int value = query.get(1);

            switch(type){

                case 1:{

                    if(map.containsKey(value)){
                        updateFrequency(frequencyMap,map.get(value),map.get(value)+1);
                        map.put(value,map.get(value)+1);
                    }
                    else{
                        map.put(value,1);
                        updateFrequency(frequencyMap,null,1);

                    }

                    break;
                }
                case 2:{

                    if(map.containsKey(value)){

                        updateFrequency(frequencyMap,map.get(value),map.get(value)-1);
                        map.put(value,map.get(value)-1);
                        if(map.get(value)==0){
                            map.remove(value);
                        }

                    }
                    break;
                }
                case 3:{
                    Integer num = frequencyMap.get(query.get(1));
                    if(num!=null && num > 0) {
                        result.add(1);
                    }
                    else{
                        result.add(0);
                    }
                    break;
                }

            }


        }

        return result;

    }

}
