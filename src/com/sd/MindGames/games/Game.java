package com.sd.MindGames.games;

import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.ReadProperties;

public abstract class Game {


   protected int longueurCombinaison;
   protected int nombreEssais;
   protected int nombreChiffresDifferents;
   protected String responseString;
   protected int valeurOk;
   protected boolean winGame;
   protected static String VICTORY="gagné!!";



    public Game(){
        longueurCombinaison=ReadProperties.readIntFromProperties("longueurCombinaison");
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

    public static String getVICTORY() {
        return VICTORY;
    }
}
