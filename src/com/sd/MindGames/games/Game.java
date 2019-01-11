package com.sd.MindGames.games;

import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.ReadProperties;

public abstract class Game {


   private int longueurCombinaison;
   private int nombreEssais;
   protected int nombreChiffresDifferents;



    public Game(){
        longueurCombinaison=ReadProperties.readIntFromProperties("longeurCombinaison");
        nombreEssais=ReadProperties.readIntFromProperties("nombreEssais");
    }


    public abstract String compareCombinaisons(int[] combinaisonSecrete, int[] reponse);


    public int getLongueurCombinaison() {
        return longueurCombinaison;
    }

    public int getNombreEssais() {return nombreEssais;}

    public int getNombreChiffresDifferents() {
        return nombreChiffresDifferents;
    }


}
