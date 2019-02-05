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

            if (!win) {
                setPlayerReponseProposee();
                checkPlayerReponseProposee();
            }

            if (!win) {
                setBotPlayerReponseProposee();
                checkBotPlayerReponseProposee();
                if(win){
                    System.out.println("la combinaison etait :"+ Arrays.toString(bot.getCombinaisonSecrete()));
                }
            }
            i++;
        }

        if (!win) {
            System.out.println("Egalité!!");
            System.out.println("la combinaison etait :"+ Arrays.toString(bot.getCombinaisonSecrete()));
        }

        bot.effacerMemoireBotPlayer();
    }
}
