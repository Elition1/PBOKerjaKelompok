package com.MainTampilan;

import java.util.Scanner;
import com.difficulty.*;
import com.leaderBoardLogic.*;

public class MainMatchGame {
    static int DelayOutput = 2000;
    private static User[] leaderboard = new User[10];
    private static int jumlahUser = 0;
    //Shindo bikin tampilan dengan ada pilihan 1. Start, 2. leaderboard, 3.Exit (yang bagian kedua dikerjain Tony)
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //Sindo
        boolean isMenuBerjalan = true;
        
        while (isMenuBerjalan) {
            UtilGame.bersihkanLayar();
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

                double waktumulai = System.nanoTime();

                //Ini yang tes tadi, yang pasang 2 buat tes, kuubah jadi gini
                logikagame game = new logikagame(ukuranPapan); 
                // ----------------------------------------------------

                Tampilan view = new Tampilan();
                int delayOutput = 1500;

                int matchedPairs = 0;

                while (matchedPairs < game.getTotalPairs()) {
                    UtilGame.bersihkanLayar();
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
                            Thread.sleep(delayOutput); 
                            continue;
                        }
                        
                        if (game.getKartu(Baris1, Kolom1).isMatched() || game.getKartu(Baris1, Kolom1).isKebuka()) {
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
                        System.out.print("Kolom : ");
                        int Kolom2 = input.nextInt();
                        
                        if (Baris2 < 0 || Baris2 >= game.getSize() || Kolom2 < 0 || Kolom2 >= game.getSize()) {
                            view.showMessage("Posisi kartu 2 di luar batas!");
                            Thread.sleep(delayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false); // tutup lagi kartu 1
                            continue;
                        }
                        
                        if ((Baris1 == Baris2 && Kolom1 == Kolom2) || game.getKartu(Baris2, Kolom2).isMatched()) {
                            view.showMessage("Gak boleh pilih kartu yang sama!");
                            Thread.sleep(delayOutput);
                            game.getKartu(Baris1, Kolom1).setKebuka(false);
                            continue;
                        }

                        Thread.sleep(2000);
                        UtilGame.bersihkanLayar();
                        view.revealBoard(game, Baris2, Kolom2);

                        // Cek Match
                        if (game.isMatched(Baris1, Kolom1, Baris2, Kolom2)) {
                            view.showMessage("nenot bij macth");
                            Thread.sleep(delayOutput); 
                            game.getKartu(Baris1, Kolom1).setMatched(true);
                            game.getKartu(Baris2, Kolom2).setMatched(true);
                            matchedPairs++;
                        } else {
                            view.showMessage("Matching Salah");
                            Thread.sleep(delayOutput); 
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

                // ubjek user untuuk itung waktu
                User player = new User(waktumulai);

                view.showMessage("Nama Inisialmu");
                input.nextLine(); //bersih enter
                String nama = input.nextLine();
                
                if (nama.isEmpty()) {
                    nama = "Player";
                }
                player.setName(nama);

                if (jumlahUser < leaderboard.length) {
                    leaderboard[jumlahUser] = player;
                    jumlahUser++;
                }
                
                for (int i = 0; i < jumlahUser - 1; i++) {
                    for (int j = 0; j < jumlahUser - i - 1; j++) {
                        if (leaderboard[j].getTime() > leaderboard[j + 1].getTime()) {
                            User temp = leaderboard[j];
                            leaderboard[j] = leaderboard[j + 1];
                            leaderboard[j + 1] = temp;
                        }
                    }
                }

                System.out.println("Skor disimpan ,waktu: " + player.getTime() + " detik.");
                try {Thread.sleep(DelayOutput);} catch (Exception e) {}

                
                // Nutup Menu 1, bikin Menu 2 dan Menu 3(Menu 2 dan 3 belum coy) (Done)
            } else if (pilihan == 2) {
                UtilGame.bersihkanLayar();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("LEADERBOARD");
                System.out.println("No.\tNama\t\tWaktu");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                if (jumlahUser == 0) {
                    System.out.println("belum ada pemain");
                } else {
                    for (int i = 0; i < jumlahUser; i++) {
                        User u = leaderboard[i];
                        System.out.println((i + 1) + ".\t" + u.getName() + "\t\t" + u.getTime() + " detik");
                    }
                }
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("enter untuk kembali ke menu.");
                input.nextLine(); // nersih enter
                input.nextLine(); // menunggu enter
            } else if (pilihan == 3) {
                System.out.println("keluar game...");
                try {Thread.sleep(DelayOutput);} catch (Exception e) {}
                isMenuBerjalan = false; // Bikin loop menu berhenti
            }
        }

        input.close();
    }
}