package com.kerkom;

public class Tampilan {
    private boolean sudahGambar = false;

    public void printBoard(logikagame game) 
    {
        if (sudahGambar) {
            System.out.print("\033[H\033[2J"); // move to top-left, then clear screen
            System.out.flush();
        }

        System.out.println("Board game");
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                Kartu k = game.getKartu(i, j);

                if (k.isKebuka() || k.isMatched()) {
                    System.out.print(String.format("%d ", k.getAngka()));
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

        sudahGambar = true;
    }
    public void revealBoard(logikagame game, int r, int c) {
        // buka kartunya
        game.getKartu(r, c).setKebuka(true);
        printBoard(game);
    }

    public void showMessage(String message) {
        System.out.println(String.format("\r%s", message));
    }
}