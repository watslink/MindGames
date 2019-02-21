package com.sd.MindGames.player;

import java.util.ArrayList;
import java.util.Random;

public class BotPlayer extends Player {

    private Random r = new Random();
    private ArrayList<int[]> listOfCombinaisonsUtilisees = new ArrayList<>();

    public BotPlayer(String namePlayer) {
        super(namePlayer);
    }

    /**
     * creation d'un combinaison aleatoire selon une longueur et un nombre de chiffres différents donnés
     * @param longeurCombinaison
     * @param nombreChiffresDifferents
     * @return
     */
    public int[] creerCombinaisonAleatoire(int longeurCombinaison, int nombreChiffresDifferents) {

        int[] combinaisonAleatoire = new int[longeurCombinaison];

        do {
            for (int i = 0; i < longeurCombinaison; i++) {
                combinaisonAleatoire[i] = r.nextInt(nombreChiffresDifferents);
            }
        } while (!verificationSiCombinaisonNonUtilisee(combinaisonAleatoire));

        listOfCombinaisonsUtilisees.add(combinaisonAleatoire);
        return combinaisonAleatoire;
    }

    /**
     * verification que la combinaison n'est pas été utilisée
     * @param combinaisonAleatoire
     * @return
     */
    private boolean verificationSiCombinaisonNonUtilisee(int[] combinaisonAleatoire) {
        for (int[] combinaisonUtilise : listOfCombinaisonsUtilisees) {
            if (combinaisonAleatoire == combinaisonUtilise) {
                return false;
            }
        }
        return true;
    }

    /**
     * efface la mémoire du Bot
     */
    public void effacerMemoireBotPlayer() {
        listOfCombinaisonsUtilisees.clear();
    }
}
