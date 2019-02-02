package com.sd.MindGames;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.games.MastermindGame;
import com.sd.MindGames.games.RechercheGame;
import com.sd.MindGames.modes.Challenger;
import com.sd.MindGames.modes.Defenseur;
import com.sd.MindGames.modes.Duel;
import com.sd.MindGames.modes.Mode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Scanner;

public class Main {

    private static Logger logger = LogManager.getLogger("Main");

    public static void main(String[] args) {

        logger.debug("Debug test");

        Scanner sc = new Scanner(System.in);
        boolean playAnotherGame = true;
        boolean playThisGame = true;
        Game newGame = null;
        int nbJeu = 0;
        int nbMode = 0;
        int nbRetry = 0;
        Mode mode = null;

        System.out.println("**************************");
        System.out.println("**Bienvenue à MindGames!**");
        System.out.println("**************************");

        while (playAnotherGame) {

            playThisGame = true;

            System.out.println();
            System.out.println("Liste des jeux:");
            System.out.println("Recherche + ou - : 1");
            System.out.println("MasterMind : 2");
            System.out.println("Votre choix?");

            nbJeu = sc.nextInt();
            if (nbJeu != 1 && nbJeu != 2) {
                System.out.println("Votre choix?");
                nbJeu = sc.nextInt();
            }

            switch (nbJeu) {
                case 1:
                    newGame = new RechercheGame();
                    break;
                case 2:
                    newGame = new MastermindGame();
                    break;
            }

            System.out.println();
            System.out.println("Modes de jeu:");
            System.out.println("Challenger: 1 ");
            System.out.println("Defenseur: 2");
            System.out.println("Defi: 3");
            System.out.println("Votre choix?");

            nbMode = sc.nextInt();
            if (nbMode != 1 && nbMode != 2 && nbMode != 3) {
                System.out.println("Votre choix?");
                nbMode = sc.nextInt();
            }

            switch (nbMode) {
                case 1:
                    mode = new Challenger(newGame);
                    break;
                case 2:
                    mode = new Defenseur(newGame);
                    break;
                case 3:
                    mode = new Duel(newGame);
                    break;
            }

            mode.start();

            while (playThisGame) {
                System.out.println();
                System.out.println("Voulez vous rejouez?");
                System.out.println("Oui, à ce jeu : 1");
                System.out.println("Oui, à un autre jeu : 2");
                System.out.println("Non : 3");
                System.out.println("Votre choix?");

                nbRetry = sc.nextInt();
                if (nbRetry != 1 && nbRetry != 2 && nbRetry != 3) {
                    System.out.println("Votre choix?");
                    nbRetry = sc.nextInt();
                }

                switch (nbRetry) {
                    case 1:
                        mode.start();
                        break;
                    case 2:
                        playThisGame = false;
                        playAnotherGame = true;
                        break;
                    case 3:
                        playThisGame = false;
                        playAnotherGame = false;
                        break;
                }
            }
        }
    }


}
