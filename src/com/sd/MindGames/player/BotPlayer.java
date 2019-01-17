package com.sd.MindGames.player;

import java.util.Random;

public class BotPlayer extends Player{

    Random r=new Random();

    public int[] createCombinaisonAleatoire(int longeurCombinaison, int nombreChiffresDifferents){

        int[] combinaisonAleatoire=new int[longeurCombinaison];

        for(int i=0;  i<longeurCombinaison; i++){
            combinaisonAleatoire[i]=r.nextInt(nombreChiffresDifferents);
        }
        return combinaisonAleatoire;
    }


}
