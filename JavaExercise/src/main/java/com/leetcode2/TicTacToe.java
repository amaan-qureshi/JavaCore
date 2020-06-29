package com.leetcode2;

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe(3);
/*        t.move(1,2,2);
        t.move(0,2,1);
        t.move(0,0,2);
        t.move(2,0,1);
        t.move(0,1,2);
        t.move(1,1,1);*/


        t.move(0,0,1);
        t.move(0,2,2);
        t.move(2,2,1);
        t.move(1,1,2);
        t.move(2,0,1);
        t.move(1,0,2);
        t.move(2,1,1);

    }

    Map<Move, List<Set<Move>>> winMap;
    int[][] board;
    int boardSize;

    public TicTacToe(int n) {
        boardSize = n;
        board = new int[n][n];
        winMap = new HashMap<>();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                winMap.put(new Move(i, j), getWinPlaces(i, j));
            }

        }

    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        if(board[row][col]!=0) return 0;

        int result = 0;
        List<Set<Move>> list = winMap.get(new Move(row, col));


        if (player == 1) {
            board[row][col] = 1;

            for(Set<Move> winLine : list){

                boolean won = true;
                for (Move move : winLine) {
                    if (board[move.r][move.c] != 1) {
                        won = false;
                    }
                }
                if (won) return 1;

            }

        } else if (player == 2) {
            board[row][col] = 2;

            for(Set<Move> winLine : list){

                boolean won = true;
                for (Move move : winLine) {
                    if (board[move.r][move.c] != 2) {
                        won = false;
                    }
                }
                if (won) return 2;

            }
        }

        return result;
    }

    List<Set<Move>> getWinPlaces(int r, int c) {

        List<Set<Move>> allPlaces = new ArrayList<>();

        Set<Move> places1 = new HashSet<>();
        for (int i = 0; i < boardSize; i++) {
            places1.add(new Move(r, i));
        }
        allPlaces.add(places1);

        Set<Move> places2 = new HashSet<>();
        for (int i = 0; i < boardSize; i++) {
            places2.add(new Move(i, c));
        }
        allPlaces.add(places2);

        if (r == c || r == boardSize - 1 - c || c == boardSize - 1 - r) {

            Set<Move> places3 = new HashSet<>();
            if (r == c) {
                for (int i = 0; i < boardSize; i++) {
                    places3.add(new Move(i, i));
                }
                allPlaces.add(places3);
            }


            Set<Move> places4 = new HashSet<>();
            if(r == boardSize - 1 - c || c == boardSize - 1 - r){
                for (int i = 0, j = boardSize - 1; i < boardSize && j >= 0; i++, j--) {
                    places4.add(new Move(i, j));
                }
                allPlaces.add(places4);
            }

        }

        return allPlaces;
    }

}

class Move {

    int r;
    int c;

    public Move(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;
        Move move = (Move) o;
        return r == move.r &&
                c == move.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}