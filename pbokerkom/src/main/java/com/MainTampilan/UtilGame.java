package com.MainTampilan;

public class UtilGame 
{
    
    public static void bersihkanLayar()
    {
        int Baris = 20;
        for(int i = 0; i < Baris; i++)
        {
            System.out.println();
        }
    }

    // Nata nanti bikin logika leaderboardnya nanti setiap difficultynya masing-masing
    // dan juga semisalnya leaderBoardnya penuh kalau ada user baru 
    // selesai levelnya lebih cepat nanti bikinnya user tersebut
    // bisa disisipkan diantara user-user tersebut
    // dengan sementara user dibelakang diremove dari array
    public static User[] Sort(User[] leaderBoard){
        return leaderBoard;
    } 
}
