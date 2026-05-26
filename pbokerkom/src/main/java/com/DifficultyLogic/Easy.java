package com.DifficultyLogic;

//mengimplementasikan interface difficultySelector
public class Easy implements DifficultySelector 
{   
    //method untuk mode Easy: mengembalikan nama difficulty "Easy", ukuran board 2, 
    //dan menampilkan pesan bahwa tingkat kesulitannya Easy.
    @Override
    public String difficultyChosen()
    {
        return "Easy";
    }

    @Override
    public int boardSize() 
    {
        return 2;
    }

    @Override
    public void difficulty() 
    {
        System.out.println("Tingkat Kesulitan: Easy (Papan 4x4)");
    }
}