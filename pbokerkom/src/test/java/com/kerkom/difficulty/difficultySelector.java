package com.kerkom.difficulty;

//interface yang berisi aturan method yang harus dibuat oleh class lain.
public interface difficultySelector 
{
        abstract String difficultyChosen();
        abstract int boardSize();
        abstract void difficulty();
}