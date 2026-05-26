package com.kerkom.Tampilan;

public class MatchGameTamp {

    public void printBoard(MatchGame2 game) {
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                if (game.isRevealed(i, j)) {
                    System.out.print(game.getTile(i, j) + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    
    public void revealBoard(MatchGame2 game, int r, int c)
    {
        if (!game.isRevealed(r, c))
        {
            game.reveal(r, c);
        }
        
        printBoard(game);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}