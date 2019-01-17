package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.Player;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Defenseur extends Mode {


    public Defenseur(Game game){
        super(game);
        start();
    }

    @Override
    public void start() {



        win=false;
        int i=0;

        setPlayerCombinaisonSecrete();

        while(i<game.getNombreEssais() && !win) {

            setAndCheckBotPlayerReponseProposee();
            i++;

        }
    }


}
