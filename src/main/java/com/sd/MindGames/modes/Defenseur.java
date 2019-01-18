package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;


public class Defenseur extends Mode {


    public Defenseur(Game game){
        super(game);
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
