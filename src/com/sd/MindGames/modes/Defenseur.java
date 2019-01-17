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

        int [] response = null;
        boolean codeOk=false;

        win=false;
        int i=0;


        System.out.println("Veuillez entrer une combinaison secrète: ");
        while (!codeOk){
            response=convertStringToTabOfInt(sc.nextLine());
            if(response!=null){
                if(checkFormatOfResponse(response)) {
                    player.setCombinaisonSecrete(response);
                    codeOk=true;
                }
                else
                    System.out.println("Erreur dans la saisie");
            }
            else
                System.out.println("Erreur dans la saisie");
        }



        while(i<game.getNombreEssais() && !win) {

            bot.createCombinaisonAleatoire(game.getLongueurCombinaison(),game.getNombreChiffresDifferents());
            int[] responseBot = bot.getCombinaisonSecrete();
            System.out.println("Proposition: " + Arrays.toString(responseBot));

            String str = game.compareCombinaisons(responseBot, response);
            System.out.println(str);
            if (str.equals(Game.getVICTORY())) {
                win = true;
            }
            i++;


        }
    }


}
