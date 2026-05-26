package com.kerkom.leaderBoardLogic;

//Class berisi settingan tampilan atau game
public class leaderBoardMedium 
{
    //Kemudahan debugging
    public static boolean WIN = false;

    //Easter Egg
    public static void WINGAME(int pilihan)
    {
        switch (pilihan)
        {
            case 67:
                System.out.println("67");
                try {Thread.sleep(1500);} catch (Exception e) {}
                break;
            case 100:
                System.out.println("Halo");
                try {Thread.sleep(1500);} catch (Exception e) {}
                break;
            case -1:
                System.out.println("");
                try {Thread.sleep(1500);} catch (Exception e) {}
                break;
            case 777:
                WIN = true;
                try {Thread.sleep(1500);} catch (Exception e) {}
                break;
        }
    }

    //Metode membersihkan layar
    public static void bersihkanLayar()
    {
        int Baris = 20;
        for(int i = 0; i < Baris; i++)
        {
            System.out.println();
        }
    }

    public void showLeaderBoard(String medium) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mencobaMenambahUser(User player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}