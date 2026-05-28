package com.LeaderBoardLogic;

//class leaderBoardHard yang mewarisi class leaderBoard
//class inijuga memakai semua atribut dan method dari leaderBoard
public class LeaderBoardHard extends LeaderBoard
{
    public LeaderBoardHard()
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

        System.out.println("Difficulty : " + difficulty + ", Board 8x8");
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
