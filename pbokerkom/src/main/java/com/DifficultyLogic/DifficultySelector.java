package com.DifficultyLogic;

//interface yang berisi aturan method yang harus dibuat oleh class lain.
public interface DifficultySelector 
{
    abstract String difficultyChosen();
    abstract int boardSize();
    abstract void difficulty();
}
