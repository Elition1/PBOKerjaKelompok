package com.kerkom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MatchGame2 {

    private int[][] mapTile;
    private boolean[][] revealed;
    private int size;
    private int totalPairs;

    public MatchGame2(int pairs) {
        this.size = pairs * 2;
        this.totalPairs = (size * size) / 2;
        this.mapTile = new int[size][size];
        this.revealed = new boolean[size][size];
        generateBoard();
    }

    private void generateBoard() {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= totalPairs; i++) {
            numbers.add(i);
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mapTile[i][j] = numbers.get(index++);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getTotalPairs() {
        return totalPairs;
    }

    public int getTile(int row, int col) {
        return mapTile[row][col];
    }

    public boolean isRevealed(int row, int col) {
        return revealed[row][col];
    }

    public void reveal(int row, int col) {
        revealed[row][col] = true;
    }
    
    public void hide(int row, int col)
    {
        revealed[row][col] = false;
    }

    public boolean isMatched(int r1, int c1, int r2, int c2) {
        return mapTile[r1][c1] == mapTile[r2][c2];
    }
}
