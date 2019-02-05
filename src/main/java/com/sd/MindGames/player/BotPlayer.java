package com.sd.MindGames.player;

import java.util.ArrayList;
import java.util.Random;

public class BotPlayer extends Player {

    private Random r = new Random();
    private ArrayList<int[]> listOfCombinaisonsUtilisees = new ArrayList<>();

    public BotPlayer(String namePlayer) {
        super(namePlayer);
    }

    public int[] creerCombinaisonAleatoire(int longeurCombinaison, int nombreChiffresDifferents) {

        int[] combinaisonAleatoire = new int[longeurCombinaison];

        do {
            for (int i = 0; i < longeurCombinaison; i++) {
                combinaisonAleatoire[i] = r.nextInt(nombreChiffresDifferents);
            }
        } while (!testSiCombinaisonNonUtilisee(combinaisonAleatoire));

        listOfCombinaisonsUtilisees.add(combinaisonAleatoire);
        return combinaisonAleatoire;
    }

    private boolean testSiCombinaisonNonUtilisee(int[] combinaisonAleatoire) {
        for (int[] combinaisonUtilise : listOfCombinaisonsUtilisees) {
            if (combinaisonAleatoire == combinaisonUtilise) {
                return false;
            }
        }
        return true;
    }

    public void effacerMemoireBotPlayer() {
        listOfCombinaisonsUtilisees.clear();
    }
}
