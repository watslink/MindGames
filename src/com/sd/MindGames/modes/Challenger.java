package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.utils.ReadProperties;

import java.util.Arrays;

public class Challenger extends Mode {


    public Challenger(Game game){
        super(game);
        start();
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
                System.out.println("Proposition: ");

                player.setReponseProposee(convertStringToTabOfInt(sc.nextLine()));
                if(player.getReponseProposee()!=null){
                    if(checkFormatOfResponse(player.getReponseProposee())) {
                        String str=game.compareCombinaisons(bot.getCombinaisonSecrete(), player.getReponseProposee());
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
