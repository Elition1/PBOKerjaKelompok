package com.kerkom.difficulty;

//mengimplementasikan interface difficultySelecto
public class Easy implements difficultySelector {
    
    //method untuk mode Easy: mengembalikan nama difficulty "Easy", ukuran board 2, 
    //dan menampilkan pesan bahwa tingkat kesulitannya Easy.
    @Override
    public String difficultyChosen()
    {
        return "Easy";
    }

    @Override
    public int boardSize() {
        return 2;
    }

    @Override
    public void difficulty() {
        System.out.println("Tingkat Kesulitan: Easy (Papan 4x4)");
    }
}