package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;

import java.util.Arrays;


public class Duel extends Mode {

    public Duel(Game newGame) {
        super(newGame);
    }

    @Override
    public void start() {

        setBotPlayerCombinaisonSecrete();
        afficherCombinaisonSecreteSiDevMode();
        setPlayerCombinaisonSecrete();

        win = false;
        int i = 0;

        while (i < game.getNombreEssais() && !win) {


            setPlayerReponseProposee();
            checkPlayerReponseProposee(ordinateur, joueur);


            if (!win) {
                setBotPlayerReponseProposee();
                checkPlayerReponseProposee(joueur, ordinateur);
                if (win) {
                    System.out.println("la combinaison etait :" + Arrays.toString(ordinateur.getCombinaisonSecrete()));
                }
            }
            i++;
        }

        if (!win) {
            System.out.println("Egalité!!");
            System.out.println("la combinaison etait :" + Arrays.toString(ordinateur.getCombinaisonSecrete()));
        }

        ordinateur.effacerMemoireBotPlayer();
    }
}
