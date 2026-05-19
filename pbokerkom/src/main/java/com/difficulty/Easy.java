package com.difficulty;

public class Easy implements difficultySelector {
    
    @Override
    public int boardSize() {
        return 2;
    }

    @Override
    public void difficulty() {
        System.out.println("Tingkat Kesulitan: Easy (Papan 4x4)");
    }
}