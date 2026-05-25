package com.DifficultyLogic;

//Shindo bikin kelas easy, medium, dan hard untuk mempetakan ukuran board
public interface DifficultySelector 
{
        abstract String difficultyChosen();
        abstract int boardSize();
        abstract void difficulty();
}
