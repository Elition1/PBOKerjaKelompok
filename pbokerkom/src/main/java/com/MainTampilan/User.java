package com.MainTampilan;

public class User 
{
    private String name;
    private int time;
    private double Waktu = System.nanoTime();

    public User(double timeStart) 
    {
        double timeEnd = System.nanoTime();
        this.time = (int) ((timeEnd - timeStart) / 1000000000.0); //siapa tau
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
}
