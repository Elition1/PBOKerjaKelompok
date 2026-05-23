package com.difficulty;

public class Impossible implements difficultySelector
{
    @Override
    public String difficultyChosen()
    {
        return "Impossible";
    }

    @Override
    public int boardSize()
    {
        return 10;
    }

    @Override
    public void difficulty()
    {
        System.out.println("Tingkat Kesulitan: Easy (Papan 20x20)");
    }
    
}
