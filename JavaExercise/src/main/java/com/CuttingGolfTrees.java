package com;

import java.util.*;

public class CuttingGolfTrees {

    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }

        Collections.sort(trees, Comparator.comparingInt(o -> o[0]));

        int sr = 0, sc = 0;
        int steps = 0;
        for (int[] t : trees) {

            int dis = calculateDistance(forest, sr, sc, t[0], t[1]);
            if (dis < 0) return -1;
            steps += dis;
            sr = t[0];
            sc = t[1];
        }
        return steps;
    }

    private int calculateDistance(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int R = forest.size();
        int C = forest.get(0).size();

        Queue<int[]> Q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];

        int[] startPair = {sr, sc, 0};
        Q.offer(startPair);
        visited[sr][sc] = true;

        while (!Q.isEmpty()) {

            int[] pair = Q.poll();

            if (pair[0] == tr && pair[1] == tc) {
                return pair[2];
            }

            for (int idx = 0; idx < dr.length; idx++) {

                int i = pair[0] + dr[idx];
                int j = pair[1] + dc[idx];

                if (i >= 0 && j >= 0 && i < R && j < C && !visited[i][j] && forest.get(i).get(j) > 0) {

                    visited[i][j] = true;
                    Q.offer(new int[]{i, j, pair[2] + 1});
                }

            }

        }

        return -1;
    }


}
