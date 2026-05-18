package com.kerkom;

//data kartu bisa disimpan jadi objek saja
public class Kartu {
    private int angka;
    private boolean terbuka;
    private boolean sudahCocok;

    public Kartu(int angka) {
        this.angka =angka;
        this.terbuka =false;
        this.sudahCocok =false;
    }
    public int getAngka(){
        return angka;
    }
    public boolean isKebuka(){
        return terbuka;
    }
    public void setKebuka(boolean terbuka){
        this.terbuka = terbuka;
    }
    public boolean isMatched(){
        return sudahCocok;
    }

    public void setMatched(boolean sudahCocok){
        this.sudahCocok = sudahCocok;
    }
}
