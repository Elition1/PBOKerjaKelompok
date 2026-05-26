package com.MainTampilan;

import java.util.Random;

public class LogikaGame {
    public Random random = new Random();
    private Kartu[][] board; 
    private int size;
    private int totalPairs;

    //Mempetakan Barisan Peta MatchGame
    public LogikaGame(int pairs) {
        this.size = pairs * 2;
        this.totalPairs =(size*size)/2; 
        this.board =new Kartu[size][size]; //kalau sebelumnya pakaai map tile dan map revealed, file kartu.java nyimpan itu biar ada encapsulation
        generateBoard();
    }

    //Membuat Barisan Angka untuk pemetaan
    private void generateBoard(){
        int[] randomNumbers = new int[size * size];

        // bikin sepasang angka
        for (int i = 0; i < totalPairs; i++) {
            randomNumbers[i * 2] = i;
            randomNumbers[i * 2 + 1] = i;
        }

        //acak angka
        for (int i = randomNumbers.length - 1; i > 0; i--) 
        {
            int j = random.nextInt(i + 1);
            int temp = randomNumbers[i];
            randomNumbers[i] = randomNumbers[j];
            randomNumbers[j] = temp;
        }

        //isi ke array objek
        for (int i = 0; i < size; i++) 
        {
            for(int j = 0; j < size; j++)
            {
                board[i][j] = new Kartu(randomNumbers[i * size + j]); 
            }   
        }
    }

    public int getSize() {
        return size;
    }

    public int getTotalPairs() {
        return totalPairs;
    }
    //pindahin ke kartu.jawa e biar rapih dan bisa diakses sama mainmatchgame
    public Kartu getKartu(int row, int col) {
        return board[row][col];
    }

    public boolean isMatched(int r1, int c1, int r2, int c2) {
        // cek kalau angkanya sama tapi posisinya beda 
        if (r1 == r2 && c1 == c2) return false;
        return board[r1][c1].getAngka() == board[r2][c2].getAngka();
    }
}
