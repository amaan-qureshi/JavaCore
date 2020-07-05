package com.leetcode;
import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Integer numOfIslands = 0;

        for(int i = 0 ; i < grid.length ; i++){

            for(int j = 0 ; j < grid[0].length ; j++){

                if(grid[i][j] == '1'){
                    Integer[] node = {i,j};
                    dfs(node,grid,visited,numOfIslands);
                }

            }

        }


        return numOfIslands;
    }

    public void dfs(Integer[] n,char[][] grid,boolean[][] visited,Integer numOfIslands){

        if(visited[n[0]][n[1]]){
            return;
        }

        Stack<List<Integer>> stack = new Stack<>();
        stack.push(Arrays.asList(n));

        while(!stack.isEmpty()){

            List<Integer> node = stack.pop();
            visited[node.get(0)][node.get(1)] = true;

            List<List<Integer>> children = getAllChildren(node,grid);
            for(List<Integer> child : children){
                stack.push(child);
            }
        }
        numOfIslands = numOfIslands+1;
    }


    List<List<Integer>> getAllChildren(List<Integer> node,char[][] grid){


        int i = node.get(0);
        int j = node.get(1);
        List<List<Integer>> list = new ArrayList<>();

        if(i>0 && grid[i-1][j] == '1'){
            list.add(Arrays.asList(new Integer[]{i-1,j}));
        }
        if(j<grid[0].length-1 && grid[i][j+1] == '1'){
            list.add(Arrays.asList(new Integer[]{i,j+1}));
        }
        if(i<grid.length-1 && grid[i+1][j] == '1'){
            list.add(Arrays.asList(new Integer[]{i+1,j}));
        }
        if(j>0 && grid[i][j-1] == '1'){
            list.add(Arrays.asList(new Integer[]{i,j-1}));
        }

        return list;
    }
}
