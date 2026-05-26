package com.kerkom.leaderBoardLogic;

public class leaderBoard 
{
    //class leaderBoard untuk menyimpan dan mengurutkan top 10 user berdasarkan waktu tercepat
    public final int MAX_USER = 10;
    protected User[] userLeaderBoard;
    protected int sizeArray = 0;
    
    public leaderBoard()
    {
        this.userLeaderBoard = new User[MAX_USER];
    } 

    public boolean mencobaMenambahUser(User user)
    {
        if(sizeArray < MAX_USER)
        {
            userLeaderBoard[sizeArray] = user;
            sizeArray++;
            leaderBoardSort(userLeaderBoard);
            return true;
        }

        if(user.getTime() < userLeaderBoard[sizeArray - 1].getTime())
        {
            userLeaderBoard[sizeArray - 1] = user;
            leaderBoardSort(userLeaderBoard);
            return true;
        }

        return false;
    }
    
    //Penyusunan LeaderBoard sesuai User time clear dan tingkat kesusahan
    public User[] leaderBoardSort(User[] leaderBoard)
    {
        for(int i = 1; i < sizeArray; i++)
        {
            User userTime = leaderBoard[i];
            double key = leaderBoard[i].getTime();
            int j = i - 1;

                while(j >= 0 && leaderBoard[j].getTime() > key) 
                {
                    leaderBoard[j + 1] = leaderBoard[j];
                    j--;
                }
            leaderBoard[j + 1] = userTime;
        }

        return leaderBoard;
    }

    public void showLeaderBoard(String difficulty)
    {
        if(sizeArray == 0)
        {
            System.out.println("Belum Ada User");
            return;
        }

        System.out.println("Difficulty : " + difficulty);
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

    public User[] getUserLeaderBoard()
    {
        return userLeaderBoard;   
    }

    public int getsizeArray()
    {
        return sizeArray;    
    }
}