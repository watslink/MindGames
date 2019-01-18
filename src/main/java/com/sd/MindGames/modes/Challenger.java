package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.utils.ReadProperties;

import java.util.Arrays;

public class Challenger extends Mode {


    public Challenger(Game game){
        super(game);
    }

    @Override
    public void start() {


        setBotPlayerCombinaisonSecrete();

        if(ReadProperties.readBooleanFromProperties("devMode")){
            System.out.println("Combinaison secrete :"+Arrays.toString(bot.getCombinaisonSecrete()));
        }

        win=false;
        int i=0;

            while(i<game.getNombreEssais() && !win){
               if(setAndCheckPlayerReponseProposee())
                   i++;
                }


    }

}
