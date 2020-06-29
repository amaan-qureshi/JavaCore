package com.leetcode2;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeDeserializeBT {

    public static void main(String[] args) {

        reverse(-2147483648);
    }

    public static int reverse(int x) {

        int y = x;
        int multiplier = 1;
        if(x < 0){
            multiplier = -1;
        }
        y = y*multiplier;

        StringBuilder sb = new StringBuilder(String.valueOf(y));
        if(sb.charAt(0) == '-') sb.deleteCharAt(0);
        sb.reverse();
        Long l = Long.parseLong(sb.toString());

        if(l > Integer.MAX_VALUE){
            return 0;
        }
        else{
            return multiplier * l.intValue();
        }



    }

    public static  List<String> topKFrequent(String[] words, int k) {

        long x  = 1;


        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            Integer freq = freqMap.getOrDefault(word, 0) + 1;
            freqMap.put(word, freq);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((a,b)-> Integer.compare(freqMap.get(b),freqMap.get(a)));

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() == k+1) {
                heap.poll();
            }

        }
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        return result;
    }




    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        serializeL(root, result);
        return result.stream().map(i -> {
            if (i == null) {
                return "NA";
            }
            return i.toString();
        }).collect(Collectors.joining(","));

    }

    public void serializeL(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        } else {
            result.add(root.val);
        }
        serializeL(root.left, result);
        serializeL(root.right, result);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] numArr = data.split(",");
        List<String> nums = new ArrayList<String>();
        for (String num : numArr) {
            nums.add(num);
        }
        return deserializeL(nums);
    }

    private TreeNode deserializeL(List<String> nums) {

        if (nums.size() == 0 || nums.get(0).equals("NA")) {
            nums.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nums.get(0)));
        nums.remove(0);
        node.left = deserializeL(nums);
        node.right = deserializeL(nums);

        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}