package com.difficulty;

//Shindo bikin kelas easy, medium, dan hard untuk mempetakan ukuran board
public interface difficultySelector 
{
        abstract String difficultyChosen();
        abstract int boardSize();
        abstract void difficulty();
}
