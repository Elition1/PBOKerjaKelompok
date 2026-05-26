package com.DifficultyLogic;

public class Hard implements DifficultySelector 
{    
    @Override
    public String difficultyChosen()
    {
        return "Hard";
    }

    @Override
    public int boardSize() 
    {
        return 4;
    }

    @Override
    public void difficulty() 
    {
        System.out.println("Tingkat Kesulitan: Hard (Papan 8x8)");
    }
}