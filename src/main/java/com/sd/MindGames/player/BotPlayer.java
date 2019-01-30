package com.sd.MindGames.player;

import java.util.ArrayList;
import java.util.Random;

public class BotPlayer extends Player{

    private Random r=new Random();
    private ArrayList<int[]> listOfCombinaisonsUtilisees=new ArrayList<>();

    public int[] createCombinaisonAleatoire(int longeurCombinaison, int nombreChiffresDifferents){

        int[] combinaisonAleatoire=new int[longeurCombinaison];

        while(!testIfCombinaisonNonUtilisee(combinaisonAleatoire)){
            for (int i = 0; i < longeurCombinaison; i++) {
                combinaisonAleatoire[i] = r.nextInt(nombreChiffresDifferents);
            }
        }

        listOfCombinaisonsUtilisees.add(combinaisonAleatoire);
        return combinaisonAleatoire;
    }

    private boolean testIfCombinaisonNonUtilisee(int[] combinaisonAleatoire){
        for (int[] combinaisonUtilisé : listOfCombinaisonsUtilisees){
            if(combinaisonAleatoire==combinaisonUtilisé){
                return false;
            }
        }
        return true;
    }

    public void resetBotMemory(){
        listOfCombinaisonsUtilisees.clear();
    }
}
