package com.LeaderBoardLogic;

//class leaderBoardEasy yang mewarisi class leaderBoard
//semua fungsi dan atribut dari leaderBoard dipakai juga di sini
public class LeaderBoardEasy extends LeaderBoard
{
    public LeaderBoardEasy()
    {
        super();
    }

    @Override
    public void showLeaderBoard(String difficulty)
    {
        if(sizeArray == 0)
        {
            System.out.println("Belum Ada User");
            return;
        }

        System.out.println("Difficulty : " + difficulty + ", Board 4x4");
        System.out.printf("""
            %-5s | %-7s | %s
            """,
            "No",
            "Nama",
            "Time");
        System.out.println("====================================");
        for(int i = 0; i < sizeArray; i++)
        {
            String nama = userLeaderBoard[i].getName();
            double time = userLeaderBoard[i].getTime();
            System.out.printf("""
                    %-5d | %-7s | %.0f
                    """,
                    (i + 1),
                    nama,
                    time);
        }
        System.out.println("====================================");
    }
}
