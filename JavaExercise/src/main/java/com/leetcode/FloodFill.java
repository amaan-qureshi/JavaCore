package com.leetcode;

import java.util.*;

public class FloodFill {

    public static void main(String[] args) {

        int[][] img = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        new FloodFill().floodFill(img, 1, 1, 2);

        /*
        111
        220
        101
         */
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {


        boolean[][] visited = new boolean[image.length][image[0].length];

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{sr, sc});

        while (!queue.isEmpty()) {

            Integer[] pair = queue.poll();

            List<Integer[]> adjacentPixels = getPixelsOfSameColor(pair, image);
            image[pair[0]][pair[1]] = newColor;
            visited[pair[0]][pair[1]] = true;

            for (Integer[] children : adjacentPixels) {
                if (!visited[children[0]][children[1]])
                    queue.offer(children);
            }

        }

        return image;

    }

    List<Integer[]> getPixelsOfSameColor(Integer[] pair, int[][] image) {

        int i = pair[0];
        int j = pair[1];
        int color = image[i][j];
        List<Integer[]> children = new ArrayList<>();
        if (i - 1 >= 0 && image[i - 1][j] == color) {
            children.add(new Integer[]{i - 1, j});
        }
        if (j + 1 < image[0].length && image[i][j + 1] == color) {
            children.add(new Integer[]{i, j + 1});
        }
        if (i + 1 < image.length && image[i + 1][j] == color) {
            children.add(new Integer[]{i + 1, j});
        }
        if (j - 1 >= 0 && image[i][j - 1] == color) {
            children.add(new Integer[]{i, j - 1});
        }
        return children;
    }

}