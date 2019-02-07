package com.sd.MindGames;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.games.MastermindGame;
import com.sd.MindGames.games.RechercheGame;
import com.sd.MindGames.modes.Challenger;
import com.sd.MindGames.modes.Defenseur;
import com.sd.MindGames.modes.Duel;
import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.Config;
import com.sd.MindGames.utils.PropertiesUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Logger logger = LogManager.getLogger("Main");

    private static Scanner sc = new Scanner(System.in);
    private static boolean playAnotherGame = true;
    private static boolean playThisGame = true;
    private static Game newGame = null;
    private static int nbJeu = 0;
    private static int nbMode = 0;
    private static int nbRejouer = 0;
    private static Mode mode = null;
    private static boolean erreur = false;

    public static void main(String[] args) {

        if (PropertiesUtils.readBooleanFromProperties("devMode") || (args.length > 0 && args[0].equals("-devMode"))) {
            Config.setDevMode(true);
            logger.info("**Mode Developpement**");
        }

        introduction();

        while (playAnotherGame) {

            playThisGame = true;

            listeJeux();

            choixDuJeu();

            listeModes();

            choixDuMode();

            mode.start();

            while (playThisGame) {

                listeRejouer();

                choixMenuRejouer();
            }
        }
    }

    /**
     * Texte d'introduction
     */
    private static void introduction() {
        System.out.println("**************************");
        System.out.println("**Bienvenue à MindGames!**");
        System.out.println("**************************");
    }

    /**
     * Definit le choix du jeu
     */
    private static void choixDuJeu() {
        do {
            nbJeu= aquisitionIntPourMenu(nbJeu);
        } while ((nbJeu != 1 && nbJeu != 2) || erreur);

        switch (nbJeu) {
            case 1:
                newGame = new RechercheGame();
                break;
            case 2:
                newGame = new MastermindGame();
                break;
        }
    }

    /**
     * Définit le choix du Mode
     */
    private static void choixDuMode() {
        do {
            nbMode= aquisitionIntPourMenu(nbMode);
        } while ((nbMode != 1 && nbMode != 2 && nbMode != 3) || erreur);

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
    }

    /**
     * Definit le choix du menu rejouer
     */
    private static void choixMenuRejouer() {
        do {
            nbRejouer= aquisitionIntPourMenu(nbRejouer);
        } while ((nbRejouer != 1 && nbRejouer != 2 && nbRejouer != 3) || erreur);

        switch (nbRejouer) {
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

    /**
     * Affichage du menu jeu
     */
    private static void listeJeux() {
        System.out.println();
        System.out.println("Liste des jeux:");
        System.out.println("Recherche + ou - : 1");
        System.out.println("MasterMind : 2");
    }

    /**
     * Affichage du menu mode
     */
    private static void listeModes() {
        System.out.println();
        System.out.println("Modes de jeu:");
        System.out.println("Challenger: 1 ");
        System.out.println("Defenseur: 2");
        System.out.println("Defi: 3");
    }

    /**
     * Affichage du menu rejouer
     */
    private static void listeRejouer() {
        System.out.println();
        System.out.println("Voulez vous rejouez?");
        System.out.println("Oui, à ce jeu : 1");
        System.out.println("Oui, à un autre jeu : 2");
        System.out.println("Non : 3");
    }

    /**
     * aquisition d'un Int via un Scanner avec gestion  de InputMismatchException
     * @param nbMenu
     * @return
     */
    private static int aquisitionIntPourMenu(int nbMenu) {
        erreur = false;
        try {
            System.out.println("Votre choix?");
            nbMenu = sc.nextInt();
        } catch (InputMismatchException e) {
            erreur = true;
            sc.nextLine();
        }

        return nbMenu;
    }
}
