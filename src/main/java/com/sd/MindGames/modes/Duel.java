package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.utils.ReadProperties;

import java.util.Arrays;

public class Duel extends Mode {


    public Duel(Game newGame) {
        super(newGame);
    }

    @Override
    public void start() {
        setBotPlayerCombinaisonSecrete();

        if(ReadProperties.readBooleanFromProperties("devMode")){
            System.out.println("Combinaison secrete :"+ Arrays.toString(bot.getCombinaisonSecrete()));
        }

        setPlayerCombinaisonSecrete();

        win=false;
        int i=0;

        while(i<game.getNombreEssais() && !win){
            if(setAndCheckPlayerReponseProposee()) {
                if(!win) {
                    setAndCheckBotPlayerReponseProposee();
                    i++;
                }
            }
        }

        if(!win){
            System.out.println("Egalité!!");
        }

        bot.resetBotMemory();
    }
}
