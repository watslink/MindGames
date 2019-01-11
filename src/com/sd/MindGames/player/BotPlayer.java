package com.sd.MindGames.player;

import java.util.Random;

public class BotPlayer extends Player{

    Random r=new Random();

    public void createCombinaisonSecreteAleatoire(int longeurCombinaison, int nombreChiffresDifferents){

        int[] combinaisonSecrete=new int[longeurCombinaison-1];

        for(int i=0;  i<longeurCombinaison; i++){
            combinaisonSecrete[i]=r.nextInt(nombreChiffresDifferents);
        }
        setCombinaisonSecrete(combinaisonSecrete);
    }
}
