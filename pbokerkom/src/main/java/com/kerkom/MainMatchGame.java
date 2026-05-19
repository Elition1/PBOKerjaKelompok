package com.kerkom;

import java.util.Scanner;
import com.difficulty.*;

public class MainMatchGame {
    //Untuk mengapuskan layar
    public static void screenCleaner()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }

    //Shindo bikin tampilan dengan ada pilihan 1. Start, 2. leaderboard, 3.Exit (yang bagian kedua dikerjain Tony)
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //Sindo
        boolean isMenuBerjalan = true;
        
        while (isMenuBerjalan) {
            screenCleaner();
            System.out.println("1. Start");
            System.out.println("2. Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Pilih: ");
            
            int pilihan = 0;
            try {
                pilihan = input.nextInt();
            } catch (Exception e) {
                System.out.println("Input harus angka");
                input.nextLine();
                continue;
            }
            
            if (pilihan == 1) {
                // Logika milih level
                System.out.println("Pilih: 1. Easy | 2. Medium | 3. Hard");
                int level = input.nextInt();
                difficultySelector diff;
                
                if (level == 1) diff = new Easy();
                else if (level == 2) diff = new Medium();
                else diff = new Hard();
                
                diff.difficulty();
                int ukuranPapan = diff.boardSize();
                try { Thread.sleep(1500); } catch(Exception e){}
                //Bates Sindo


                //Ini yang tes tadi, yang pasang 2 buat tes, kuubah jadi gini
                logikagame game = new logikagame(ukuranPapan); 
                // ----------------------------------------------------

                Tampilan view = new Tampilan();
                int DelayOutput = 1500;

                int matchedPairs = 0;

                while (matchedPairs < game.getTotalPairs()) {
                    screenCleaner();
                    view.printBoard(game);

                    try {
                        // Pilih kartu pertama
                        view.showMessage("Pilih kartu pertama (baris lalu kolom): ");
                        System.out.print(String.format("\r%s", "Baris :"));
                        int r1 = input.nextInt();
                        System.out.print(String.format("\r%s", "Kolom :"));
                        int c1 = input.nextInt();
                        
                        if (r1 < 0 || r1 >= game.getSize() || c1 < 0 || c1 >= game.getSize()) {
                            view.showMessage("Posisi kartu 1 di luar batas!");
                            Thread.sleep(DelayOutput); 
                            continue;
                        }
                        
                        if (game.getKartu(r1, c1).isMatched() || game.getKartu(r1, c1).isKebuka()) {
                            view.showMessage("Kartu itu udah kebuka!");
                            Thread.sleep(DelayOutput); 
                            continue;
                        }

                        screenCleaner();
                        view.revealBoard(game, r1, c1);           

                        // Pilih kartu kedua
                        view.showMessage("Pilih kartu kedua (baris lalu kolom): ");
                        System.out.print(String.format("\r%s", "Baris :"));
                        int r2 = input.nextInt();
                        System.out.print(String.format("\r%s", "Kolom :"));
                        int c2 = input.nextInt();
                        
                        if (r2 < 0 || r2 >= game.getSize() || c2 < 0 || c2 >= game.getSize()) {
                            view.showMessage("Posisi kartu 2 di luar batas!");
                            Thread.sleep(DelayOutput);
                            game.getKartu(r1, c1).setKebuka(false); // tutup lagi kartu 1
                            continue;
                        }
                        
                        if ((r1 == r2 && c1 == c2) || game.getKartu(r2, c2).isMatched()) {
                            view.showMessage("Gak boleh pilih kartu yang sama!");
                            Thread.sleep(DelayOutput);
                            game.getKartu(r1, c1).setKebuka(false);
                            continue;
                        }

                        Thread.sleep(2000);
                        screenCleaner();
                        view.revealBoard(game, r2, c2);

                        // Cek Match
                        if (game.isMatched(r1, c1, r2, c2)) {
                            view.showMessage("nenot bij macth");
                            Thread.sleep(DelayOutput); 
                            game.getKartu(r1, c1).setMatched(true);
                            game.getKartu(r2, c2).setMatched(true);
                            matchedPairs++;
                        } else {
                            view.showMessage("nenot bij salah");
                            Thread.sleep(DelayOutput); 
                            game.getKartu(r1, c1).setKebuka(false);
                            game.getKartu(r2, c2).setKebuka(false);
                        }
                        
                    } catch (Exception e) {
                        view.showMessage("Input harus angka");
                        input.nextLine(); // clear buffer
                    }
                }

                view.printBoard(game);
                view.showMessage("SELAMAT! Kamu menang!");


        // Nutup Menu 1, bikin Menu 2 dan Menu 3(Menu 2 dan 3 belum coy)
                System.out.println("Balik ke menu awal...");
                try { Thread.sleep(2000); } catch(Exception e){}
                
            } else if (pilihan == 2) {
                System.out.println("Menu Leaderboard - Tugasnya Tony");
                input.nextLine(); input.nextLine(); // Biar berhenti bentar
            } else if (pilihan == 3) {
                System.out.println("Keluar game.");
                isMenuBerjalan = false; // Bikin loop menu berhenti
            }
        }

        input.close();
    }
}