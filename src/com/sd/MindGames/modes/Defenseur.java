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

            bot.setReponseProposee(bot.createCombinaisonAleatoire(game.getLongueurCombinaison(),game.getNombreChiffresDifferents()));

            System.out.println("Proposition: " + Arrays.toString(bot.getReponseProposee()));

            String str = game.compareCombinaisons(bot.getReponseProposee(), player.getCombinaisonSecrete());
            System.out.println(str);
            if (str.equals(Game.getVICTORY())) {
                win = true;
            }
            i++;


        }
    }


}
