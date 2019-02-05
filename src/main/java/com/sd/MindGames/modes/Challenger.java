package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;

import java.util.Arrays;


public class Challenger extends Mode {


    public Challenger(Game game) {
        super(game);
    }

    @Override
    public void start() {

        setBotPlayerCombinaisonSecrete();
        afficherCombinaisonSecreteSiDevMode();

        win = false;
        int i = 0;

        while (i < game.getNombreEssais() && !win) {
            setPlayerReponseProposee();
            checkPlayerReponseProposee(bot,player);
            i++;
        }
        if (!win) {
            System.out.println(player.getNom()+" a perdu!");
            System.out.println("la combinaison etait :"+ Arrays.toString(bot.getCombinaisonSecrete()));
        }
    }
}
