package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;


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
            if (setAndCheckPlayerReponseProposee()) {
                if (!win) {
                    setAndCheckBotPlayerReponseProposee();
                    i++;
                }
            }
        }

        if (!win) {
            System.out.println("Egalité!!");
        }

        bot.resetBotMemory();
    }
}
