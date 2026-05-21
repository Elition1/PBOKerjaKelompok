package com.MainTampilan;

import java.util.Scanner;
import com.difficulty.*;

public class MainMatchGame {
    static int DelayOutput = 2000;
    //Shindo bikin tampilan dengan ada pilihan 1. Start, 2. leaderboard, 3.Exit (yang bagian kedua dikerjain Tony)
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //Sindo
        boolean isMenuBerjalan = true;
        
        while (isMenuBerjalan) {
            Tampilan.bersihkanLayar();
            int pilihan = 0;
            System.out.println("Matching Game : Kelompok Romusha");
            System.out.println("1. Start");
            System.out.println("2. Leaderboard");
            System.out.println("3. Exit");
            System.out.println("=====================");
            System.out.print("Pilih: ");
            
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
                //Bates Sindo

                //Ini yang tes tadi, yang pasang 2 buat tes, kuubah jadi gini
                logikagame game = new logikagame(ukuranPapan); 
                // ----------------------------------------------------

                Tampilan view = new Tampilan();
                int DelayOutput = 1500;

                int matchedPairs = 0;

                while (matchedPairs < game.getTotalPairs()) {
                    Tampilan.bersihkanLayar();
                    view.printBoard(game);

                    try {
                        // Pilih kartu pertama
                        view.showMessage("Pilih kartu pertama (baris lalu kolom): ");
                        System.out.print("Baris : ");
                        int Baris1 = input.nextInt();
                        System.out.print("Kolom : ");
                        int Kolom1 = input.nextInt();
                        
                        if (Baris1 < 0 || Baris1 >= game.getSize() || Kolom1 < 0 || Kolom1 >= game.getSize()) {
                            view.showMessage("Posisi kartu 1 di luar batas!");
                            Thread.sleep(DelayOutput); 
                            continue;
                        }
                        
                        if (game.getKartu(Baris1, Kolom1).isMatched() || game.getKartu(Baris1, Kolom1).isKebuka()) {
                            view.showMessage("Kartu itu udah kebuka!");
                            Thread.sleep(DelayOutput); 
                            continue;
                        }

                        Tampilan.bersihkanLayar();
                        view.revealBoard(game, Baris1, Kolom1);           

                        // Pilih kartu kedua
                        view.showMessage("Pilih kartu kedua (baris lalu kolom): ");
                        System.out.print("Baris : ");
                        int Baris2 = input.nextInt();
                        System.out.print("Kolom : ");
                        int Kolom2 = input.nextInt();
                        
                        if (Baris2 < 0 || Baris2 >= game.getSize() || Kolom2 < 0 || Kolom2 >= game.getSize()) {
                            view.showMessage("Posisi kartu 2 di luar batas!");
                            Thread.sleep(DelayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false); // tutup lagi kartu 1
                            continue;
                        }
                        
                        if ((Baris1 == Baris2 && Kolom1 == Kolom2) || game.getKartu(Baris2, Kolom2).isMatched()) {
                            view.showMessage("Gak boleh pilih kartu yang sama!");
                            Thread.sleep(DelayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false);
                            continue;
                        }

                        Thread.sleep(2000);
                        Tampilan.bersihkanLayar();
                        view.revealBoard(game, Baris2, Kolom2);

                        // Cek Match
                        if (game.isMatched(Baris1, Kolom1, Baris2, Kolom2)) {
                            view.showMessage("nenot bij macth");
                            Thread.sleep(DelayOutput); 
                            game.getKartu(Baris1, Kolom1).setMatched(true);
                            game.getKartu(Baris2, Kolom2).setMatched(true);
                            matchedPairs++;
                        } else {
                            view.showMessage("Matching Salah");
                            Thread.sleep(DelayOutput); 
                            game.getKartu(Baris1, Kolom1).setKebuka(false);
                            game.getKartu(Baris2, Kolom2).setKebuka(false);
                        }
                        
                    } catch (Exception e) {
                        view.showMessage("Input harus angka");
                        input.nextLine(); // clear buffer
                    }
                }

                view.printBoard(game);
                view.showMessage("SELAMAT! Kamu menang!");

                try {Thread.sleep(DelayOutput);} catch (Exception e) {}

                
                // Nutup Menu 1, bikin Menu 2 dan Menu 3(Menu 2 dan 3 belum coy)
            } else if (pilihan == 2) {
                System.out.println("Menu Leaderboard - Tugasnya Tony");
                input.nextLine(); input.nextLine(); // Biar berhenti bentar
            } else if (pilihan == 3) {
                System.out.println("Keluar game...");
                try {Thread.sleep(DelayOutput);} catch (Exception e) {}
                isMenuBerjalan = false; // Bikin loop menu berhenti
            }
        }

        input.close();
    }
}