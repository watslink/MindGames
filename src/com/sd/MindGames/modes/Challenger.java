package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;
import com.sd.MindGames.utils.ReadProperties;

import java.util.Arrays;
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
        System.out.println("Retrouvez la combinaison Mystére de "+game.getLongueurCombinaison()+" chiffres !");
        if(ReadProperties.readBooleanFromProperties("devMode")){
            System.out.println("Combinaison secrete :"+Arrays.toString(bot.getCombinaisonSecrete()));
        }
        win=false;
        int i=0;

            while(i<game.getNombreEssais() && !win){
                System.out.println("Proposition: ");

                response=convertStringToTabOfInt(sc.nextLine());
                if(response!=null){
                    if(checkFormatOfResponse(response)) {
                        String str=game.compareCombinaisons(bot.getCombinaisonSecrete(), response);
                        System.out.println(str);
                        if(str.equals(Game.getVICTORY())){win=true;}
                        i++;
                    }
                    else
                        System.out.println("Erreur dans la saisie");
                }

                else
                    System.out.println("Erreur dans la saisie");
                }


    }

}
