package com.Game;

import java.util.Scanner;

import com.DifficultyLogic.*;
import com.LeaderBoardLogic.*;
import com.MainTampilan.*;
import com.settings.UtilGame;

public class MainMatchGame 
{
    static LeaderBoardEasy leaderBoardEasy = new LeaderBoardEasy();
    static LeaderBoardMedium leaderBoardMedium = new LeaderBoardMedium();
    static LeaderBoardHard leaderBoardHard = new LeaderBoardHard();
    static int delayOutput = 1500;
    static Tampilan view = new Tampilan();
    static Scanner input = new Scanner(System.in);
    
    //Shindo bikin tampilan dengan ada pilihan 1. Start, 2. leaderboard, 3.Exit (yang bagian kedua dikerjain Tony)
    public static void main(String[] args) 
    {
        boolean isMenuBerjalan = true;
        
        while (isMenuBerjalan) 
        {
            UtilGame.bersihkanLayar();
            int pilihan = -1;
            view.showMessage("Matching Game : Kelompok Romusha");
            view.showMessage("1. Start");
            view.showMessage("2. Leaderboard");
            view.showMessage("3. Exit");
            view.showMessage("=====================");
            System.out.print("Pilih: ");
            
            try 
            {
                pilihan = input.nextInt();
            } 
            catch (Exception e) 
            {
                view.showMessage("Input harus angka");
                input.nextLine();
                continue;
            }
            
            try {Thread.sleep(delayOutput);} catch (Exception e){}

            if (pilihan == 1) 
            {
                // Logika milih level
                view.showMessage("Pilih: 1. Easy | 2. Medium | 3. Hard");
                int level = input.nextInt();
                
                DifficultySelector diff;
                
                switch (level) 
                {
                    case 1:
                        diff = new Easy();
                        break;
                    case 2:
                        diff = new Medium();
                        break; 
                    case 3:
                        diff = new Hard();
                        break;
                    default:
                        view.showMessage("Salah Pilih, Coba Lagi");
                        continue;
                }

                String diffSelect = diff.difficultyChosen();
                diff.difficulty();
                int ukuranPapan = diff.boardSize();

                double waktumulai = System.nanoTime();

                LogikaGame game = new LogikaGame(ukuranPapan); 

                int matchedPairs = 0;

                while (matchedPairs < game.getTotalPairs()) 
                {
                    UtilGame.bersihkanLayar();
                    view.printBoard(game);

                    try 
                    {
                        // Pilih kartu pertama
                        view.showMessage("Pilih kartu pertama (baris lalu kolom): ");
                        System.out.print("Baris : ");
                        int Baris1 = input.nextInt();
                        input.nextLine();
                        System.out.print("Kolom : ");
                        int Kolom1 = input.nextInt();
                        input.nextLine();
                        
                        if (Baris1 < 0 || Baris1 >= game.getSize() || Kolom1 < 0 || Kolom1 >= game.getSize()) 
                        {
                            view.showMessage("Posisi kartu 1 di luar batas!");
                            Thread.sleep(delayOutput); 
                            continue;
                        }
                        
                        if (game.getKartu(Baris1, Kolom1).isMatched() || game.getKartu(Baris1, Kolom1).isKebuka()) 
                        {
                            view.showMessage("Kartu itu udah kebuka!");
                            Thread.sleep(delayOutput); 
                            continue;
                        }

                        UtilGame.bersihkanLayar();
                        view.revealBoard(game, Baris1, Kolom1);           

                        // Pilih kartu kedua
                        view.showMessage("Pilih kartu kedua (baris lalu kolom): ");
                        System.out.print("Baris : ");
                        int Baris2 = input.nextInt();
                        input.nextLine();
                        System.out.print("Kolom : ");
                        int Kolom2 = input.nextInt();
                        input.nextLine();

                        // Secret Feature
                        UtilGame.WINGAME(Kolom2);
                        
                        //Kemudahan debugging
                        if(UtilGame.WIN)
                        {
                            UtilGame.WIN = false;
                            matchedPairs = game.getTotalPairs();
                            continue;
                        }

                        if (Baris2 < 0 || Baris2 >= game.getSize() || Kolom2 < 0 || Kolom2 >= game.getSize()) 
                        {
                            view.showMessage("Posisi kartu 2 di luar batas!");
                            Thread.sleep(delayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false); // tutup lagi kartu 1
                            continue;
                        }
                        
                        if ((Baris1 == Baris2 && Kolom1 == Kolom2) || game.getKartu(Baris2, Kolom2).isMatched()) 
                        {
                            view.showMessage("Gak boleh pilih kartu yang sama!");
                            Thread.sleep(delayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false);
                            continue;
                        }

                        UtilGame.bersihkanLayar();
                        view.revealBoard(game, Baris2, Kolom2);

                        // Cek Match
                        if (game.isMatched(Baris1, Kolom1, Baris2, Kolom2)) 
                        {
                            view.showMessage("Match Benar");
                            Thread.sleep(delayOutput); 
                            game.getKartu(Baris1, Kolom1).setMatched(true);
                            game.getKartu(Baris2, Kolom2).setMatched(true);
                            matchedPairs++;
                        } 
                        else 
                        {
                            view.showMessage("Match Salah");
                            Thread.sleep(delayOutput); 
                            game.getKartu(Baris1, Kolom1).setKebuka(false);
                            game.getKartu(Baris2, Kolom2).setKebuka(false);
                        }    
                    } 
                    catch (Exception e) 
                    {
                        view.showMessage("Input harus angka");
                        try {Thread.sleep(delayOutput);} catch (Exception w) {}
                        input.nextLine(); // clear buffer
                    }
                }

                view.printBoard(game);
                view.showMessage("SELAMAT! Kamu menang!");

                double waktuakhir = System.nanoTime();
                int time = (int) ((waktuakhir - waktumulai) / 1000000000.0); //siapa tau

                view.showMessage("Nama Inisialmu : ");
                String nama = input.nextLine();
                
                if (nama.isEmpty()) 
                {
                    nama = "Player";
                }

                User player = new User(time, nama);

                switch (diffSelect)
                {
                    case "Easy":
                        player.setDifficulty(diffSelect);
                        leaderBoardEasy.mencobaMenambahUser(player);
                        break;
                    case "Medium":
                        player.setDifficulty(diffSelect);
                        leaderBoardMedium.mencobaMenambahUser(player);
                        break;
                    case "Hard":
                        player.setDifficulty(diffSelect);
                        leaderBoardHard.mencobaMenambahUser(player);
                        break;
                }
               
                view.showMessage("Skor disimpan ,waktu: " + player.getTime() + " detik, Kesusahan: " + player.getDifficulty());
                try {Thread.sleep(delayOutput);} catch (Exception e) {}
            } 
            else if (pilihan == 2) 
            {
                UtilGame.bersihkanLayar();
                view.showMessage("Silahkan Kategori Tingkat Kesulitan LeaderBoard");
                view.showMessage("1. Easy");
                view.showMessage("2. Medium");
                view.showMessage("3. Hard");
                System.out.print("Pilihan : ");
                pilihan = -1;
                try 
                {
                    pilihan = input.nextInt();
                    input.nextLine();
                    Thread.sleep(delayOutput);
                } 
                catch (Exception e) {input.nextLine();}
                
                switch (pilihan)
                {
                    case 1:
                        leaderBoardEasy.showLeaderBoard("Easy");
                        break;
                    case 2:
                        leaderBoardMedium.showLeaderBoard("Medium");
                        break;
                    case 3:
                        leaderBoardHard.showLeaderBoard("Hard");
                        break;
                    default:
                        view.showMessage("Something's Wrong, try again");
                        try {Thread.sleep(delayOutput);} catch (Exception e){}
                        break;
                }
                view.showMessage("Press Enter to go back");
                input.nextLine(); // nersih enter
            } 
            else if (pilihan == 3) 
            {
                view.showMessage("Keluar Game...");
                try {Thread.sleep(delayOutput);} catch (Exception e) {}
                isMenuBerjalan = false; // Bikin loop menu berhenti
            }
        }
        input.close();
    }
}