package com.MainTampilan;

public class User 
{
    private String name;
    private int time;
    private double Waktu = System.nanoTime();

    public User(double timeStart) 
    {}

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
}
