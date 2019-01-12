package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;

import java.util.Scanner;

public class Challenger extends Mode {

    BotPlayer bot;
    int[]response;


    public Challenger(Game game){
        super(game);
        bot= new BotPlayer();
        start();
    }

    @Override
    public void start() {

        bot.createCombinaisonSecreteAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents());

        win=false;
        int i=0;

            while(i<game.getNombreEssais() && !win){
                System.out.println("Proposition: ");

                response=convertStringToTabOfInt(sc.nextLine());

                if(checkFormatOfResponse(response)) {
                    String str=game.compareCombinaisons(bot.getCombinaisonSecrete(), response);
                    System.out.println(str);
                    if(str.equals(Game.getVICTORY())){win=true;}
                    i++;
                }
                else
                    System.out.println("Erreur dans la saisie");
            }
    }

}
