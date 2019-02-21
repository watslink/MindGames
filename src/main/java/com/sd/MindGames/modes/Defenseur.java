package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;


public class Defenseur extends Mode {


    public Defenseur(Game game) {
        super(game);
    }

    @Override
    public void start() {

        win = false;
        int i = 0;

        setPlayerCombinaisonSecrete();

        while (i < game.getNombreEssais() && !win) {
            setBotPlayerReponseProposee();
            checkPlayerReponseProposee(joueur, ordinateur);
            i++;
        }

        if (!win) {
            System.out.println(ordinateur.getNom()+" a perdu, "+ joueur.getNom()+" a gagné!");
        }

        ordinateur.effacerMemoireBotPlayer();
    }
}
