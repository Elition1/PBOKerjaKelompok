package com.kerkom;

import java.util.ArrayList;
import java.util.Collections;

public class logikagame {

    private Kartu[][] board; 
    private int size;
    private int totalPairs;

    public logikagame(int pairs) {
        this.size = pairs*2;
        this.totalPairs =(size*size)/2; 
        this.board =new Kartu[size][size]; //kalau sebelumnya pakaai map tile dan map revealed, file kartu.java nyimpan itu biar ada encapsulation
        generateBoard();
    }

    private void generateBoard(){
        ArrayList<Integer> numbers = new ArrayList<>();

        // bikin sepasang angka
        for (int i = 1; i <= totalPairs; i++) {
            numbers.add(i);
            numbers.add(i);
        }

//acak angka
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Kartu(numbers.get(index++)); 
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getTotalPairs() {
        return totalPairs;
    }
//aku pindahin ke kartu.jawa e biar rapih dan bisa diakses sama mainmatchgame
    public Kartu getKartu(int row, int col) {
        return board[row][col];
    }

    public boolean isMatched(int r1, int c1, int r2, int c2) {
        // cek kalau angkanya sama tapi posisinya beda 
        if (r1 == r2 && c1 == c2) return false;
        return board[r1][c1].getAngka() == board[r2][c2].getAngka();
    }
}
