package com.kerkom;

public class User 
{
    private String name;
    private int time;
    private int percobaan;

    public User(String name, int time, int percobaan) 
    {
        name = name;
        time = 0;
        percobaan = 0;
    }

    public void tambahCobaan()
    {
        percobaan++;
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

    public int getPercobaan() {
        return percobaan;
    }
    
}
