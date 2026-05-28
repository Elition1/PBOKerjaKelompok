package com.settings;

//Class berisi settingan tampilan atau game
public class UtilGame 
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
                System.out.println("Rawr");
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
        int Baris = 40;
        for(int i = 0; i < Baris; i++)
        {
            System.out.println();
        }
    }
}
