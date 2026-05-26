package com.kerkom.difficulty;

//class Medium yang memakai interface difficultySelector.
public class Medium implements difficultySelector {
    
    //mengembalikan nama "Medium", ukuran board 3, dan menampilkan pesan bahwa 
    //tingkat kesulitannya Medium dengan papan 6x6
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