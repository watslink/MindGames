package com.sd.MindGames;

import com.sd.MindGames.games.AbstractGame;
import com.sd.MindGames.games.MastermindGame;
import com.sd.MindGames.games.RechercheGame;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean playAnotherGame=true;
        boolean playThisGame=true;
        AbstractGame newGame = null;
        int nb=0;

        System.out.println("**************************");
        System.out.println("**Bienvenue à MindGames!**");
        System.out.println("**************************");

        while (playAnotherGame) {

            playThisGame=true;

            System.out.println("");
            System.out.println("Listes des jeux:");
            System.out.println("Recherche + ou - : 1");
            System.out.println("MasterMind : 2");
            System.out.println("Votre choix?");

            nb = sc.nextInt();
            if (nb != 1 && nb != 2) {
                System.out.println("Votre choix?");
                nb = sc.nextInt();
            }

            switch (nb) {
                case 1:
                    newGame = new RechercheGame();
                    break;
                case 2:
                    newGame = new MastermindGame();
                    break;
            }

            while (playThisGame) {
                System.out.println("Voulez vous rejouez?");
                System.out.println("Oui, à ce jeu : 1");
                System.out.println("Oui, à un autre jeu : 2");
                System.out.println("Non : 3");
                System.out.println("Votre choix?");

                nb = sc.nextInt();
                if (nb != 1 && nb != 2 && nb != 3) {
                    System.out.println("Votre choix?");
                    nb = sc.nextInt();
                }

                switch (nb) {
                    case 1:
                        newGame.load();
                        break;
                    case 2:
                        playThisGame=false;
                        playAnotherGame = true;
                        break;
                    case 3:
                        playThisGame=false;
                        playAnotherGame = false;
                        break;
                }
            }
        }
    }


}
