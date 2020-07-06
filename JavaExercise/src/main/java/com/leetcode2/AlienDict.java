package com.leetcode2;

import java.util.*;

public class AlienDict {

    public static void main(String[] args) {
        //AlienDict al = new AlienDict();
        //System.out.println(al.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));


        int[] array =  {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i : array){

            heap.add(i);
            if(heap.size()>3){
                //heap.remove();
            }

        }

        int[] result = new int[3];
        for(int i = 2 ; i >= 0 ; i--){

            /*if(!heap.isEmpty()){
                result[i] = (heap.poll());
            }*/

        }
        System.out.println();

       // return result;




    }

    public String alienOrder(String[] words) {

        //Step 1
        Map<Character,ArrayList<Character>>  graph = new HashMap<>();
        Map<Character,Integer> countMap = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                countMap.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        //Step2
        for(int i = 0 ; i < words.length-1 ; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for(int j = 0 ; j < Math.min(word1.length(),word2.length()) ; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    countMap.put(word2.charAt(j),countMap.get(word2.charAt(j))+1);
                    break;
                }
            }

        }

        //Step 3

        Queue<Character> q = new LinkedList<>();
        for(Character c : countMap.keySet()){
            if(countMap.get(c).equals(0)){
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!q.isEmpty()){

            Character c  = q.poll();
            sb.append(c);

            ArrayList<Character> dependencies = graph.get(c);

            for(Character dependency : dependencies){

                int currentCount = countMap.get(dependency) - 1;
                countMap.put(dependency,currentCount);
                if(currentCount == 0){
                    q.add(dependency);
                }
            }


        }



        return sb.toString();
    }


}
