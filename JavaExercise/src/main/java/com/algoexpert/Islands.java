package com.algoexpert;

// Java program to count islands in boolean 2D matrix
import java.util.*;
import java.lang.*;

public class Islands {
    // No of rows and columns
   /* static final int ROW = 5, COL = 5;

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given
    // boolean 2D matrix
    int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }*/

    // Driver method
    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][]{
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        Islands I = new Islands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }

    private int countIslands(int[][] m) {

        boolean [][] visited = new boolean[m.length][m[0].length];
        Integer islands = 0;

        for(int i = 0 ; i < m.length ; i++){

            for(int j = 0 ; j < m[i].length ; j++) {

                if(m[i][j] == 1 && !visited[i][j]) {
                    search(m, i, j, visited);
                    islands++;
                }

            }

        }



        return islands;
    }

    private void search(int[][] m, int i, int j, boolean[][] visited) {

        if(visited[i][j]) return;

        visited[i][j] = true;

        for(Integer[] children : getEligibleChildren(m,i,j)){

            search(m,children[0],children[1],visited);

        }

    }

    private List<Integer[]> getEligibleChildren(int[][] m, int i, int j) {

        List<Integer[]> children = new ArrayList<>();

        if(isValidIndex(i - 1, j - 1,m) && m[i - 1][j - 1] == 1){
            children.add(new Integer[]{i - 1, j - 1});
        }

        if(isValidIndex(i - 1, j,m) && m[i - 1][j] == 1){
            children.add(new Integer[]{i - 1, j});
        }

        if(isValidIndex(i - 1, j + 1,m) &&m[i - 1][j + 1] == 1){
            children.add(new Integer[]{i - 1, j + 1});
        }

        if(isValidIndex(i, j + 1,m) &&m[i][j + 1] == 1){
            children.add(new Integer[]{i, j + 1});
        }

        if(isValidIndex(i + 1, j + 1,m) && m[i + 1][j + 1] == 1){
            children.add(new Integer[]{i + 1, j + 1});
        }

        if(isValidIndex(i + 1, j,m) && m[i + 1][j] == 1){
            children.add(new Integer[]{i + 1, j});
        }

        if(isValidIndex(i + 1, j - 1,m) && m[i + 1][j - 1] == 1){
            children.add(new Integer[]{i + 1, j - 1});
        }

        if(isValidIndex(i, j - 1,m) && m[i][j-1] == 1){
            children.add(new Integer[]{i, j - 1});
        }

        return children;
    }

    private boolean isValidIndex(int i, int j, int[][] m) {

        int width = m.length;
        int height = m[0].length;

        return (i >= 0 && i < width) && (j>=0 && j < height);
    }
}
