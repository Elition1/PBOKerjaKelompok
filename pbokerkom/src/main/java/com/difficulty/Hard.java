package com.difficulty;

public class Hard implements difficultySelector {
    
    @Override
    public int boardSize() {
        return 4;
    }

    @Override
    public void difficulty() {
        System.out.println("Tingkat Kesulitan: Hard (Papan 8x8)");
    }
}