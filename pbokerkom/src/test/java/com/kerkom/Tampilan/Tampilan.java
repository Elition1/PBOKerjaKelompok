package com.kerkom.Tampilan;

public class Tampilan{
    
    //untuk menampilkan board permainan ke jendela output
    public void printBoard(logikaGame game) {
        System.out.println("Board game");
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                Kartu k = game.getKartu(i, j);
                
                // kalau kebuka atau udah match, tampilin angkanya
                if (k.isKebuka() || k.isMatched()) {
                    System.out.print(k.getAngka() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    
    public void revealBoard(logikaGame game, int r, int c) {
        
        // buka kartunya
        game.getKartu(r, c).setKebuka(true);
        printBoard(game);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}