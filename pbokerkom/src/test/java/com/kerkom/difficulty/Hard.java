package com.kerkom.difficulty;

//mengimplementasikan interface difficultySelecto
public class Hard implements difficultySelector {
    
    //method untuk mode Hard: mengembalikan nama "Hard", ukuran board 4, dan 
    //menampilkan pesan bahwa tingkat kesulitannya Hard dengan papan 8x8.
    @Override
    public String difficultyChosen()
    {
        return "Hard";
    }

    @Override
    public int boardSize() {
        return 4;
    }

    @Override
    public void difficulty() {
        System.out.println("Tingkat Kesulitan: Hard (Papan 8x8)");
    }
}