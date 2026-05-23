package com.difficulty;

public class Medium implements difficultySelector {
    
    @Override
    public String difficultyChosen()
    {
        return "Medium";
    }

    @Override
    public int boardSize() {
        return 3;
    }

    @Override
    public void difficulty() {
        System.out.println("Tingkat Kesulitan: Medium (Papan 6x6)");
    }
}