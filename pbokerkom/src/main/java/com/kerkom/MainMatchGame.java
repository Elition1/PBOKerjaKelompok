package com.kerkom;

import java.util.Scanner;

public class MainMatchGame {
    public static void main(String[] args) {
        MatchGame2 game = new MatchGame2(2);
        MatchGameTamp view = new MatchGameTamp();
        Scanner input = new Scanner(System.in);

        int matchedPairs = 0;

        while (matchedPairs < game.getTotalPairs()) {
            view.printBoard(game);

            view.showMessage("Pilih kartu pertama (baris kolom): ");
            int r1 = input.nextInt();
            int c1 = input.nextInt();
            view.revealBoard(game, r1, c1);
            
            view.showMessage("Pilih kartu kedua (baris kolom): ");
            int r2 = input.nextInt();
            int c2 = input.nextInt();
            view.revealBoard(game, r2, c2);

            if (r1 < 0 || r1 >= game.getSize() || c1 < 0 || c1 >= game.getSize() ||
                r2 < 0 || r2 >= game.getSize() || c2 < 0 || c2 >= game.getSize()) {
                view.showMessage("Posisi tidak valid.");
                continue;
            }
            
            if (game.isMatched(r1, c1, r2, c2)) {
                view.showMessage("Match!");
                game.reveal(r1, c1);
                game.reveal(r2, c2);
                matchedPairs++;
            } else {
                game.hide(r1, c1);
                game.hide(r2, c2);
                view.showMessage("Tidak match.");
            }
        }

        view.printBoard(game);
        view.showMessage("Selamat! Semua pasangan sudah ditemukan.");
        input.close();
    }
}