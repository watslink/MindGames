package com.sd.MindGames.games;

import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.ReadProperties;

public abstract class Game {


   protected int longueurCombinaison;
   protected int nombreEssaisMax;
   protected int nombreEssaisActuel;
   protected int nombreChiffresDifferents;
   protected String responseString;
   protected int valeurOk;

   protected boolean winGame;
   protected static String VICTORY="gagné!!";



    public Game(){
        longueurCombinaison=ReadProperties.readIntFromProperties("longueurCombinaison");
        nombreEssaisMax=ReadProperties.readIntFromProperties("nombreEssais");
        nombreEssaisActuel=0;

    }

    public abstract void getIntroduction();


    public abstract String compareCombinaisons(int[] combinaisonSecrete, int[] reponse);





    public int getLongueurCombinaison() {
        return longueurCombinaison;
    }

    public int getNombreEssais() {return nombreEssaisMax;}

    public int getNombreChiffresDifferents() {
        return nombreChiffresDifferents;
    }

    public static String getVictory() {
        return VICTORY;
    }


}
