package com.LeaderBoardLogic;

//class User untuk menyimpan data pemain.
public class User 
{
    private String name;
    private int time;
    private String difficulty;

    public User(int time, String name) 
    {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }
}
