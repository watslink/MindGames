package com.sd.MindGames.games;

import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.ReadProperties;

public abstract class Game {


   private int longueurCombinaison;
   private int nombreChiffresDifferents;

    public Game(){

    }


    protected abstract String compareCombinaisons(int[] combinaisonSecrete, int[] reponse);


    public int getLongueurCombinaison() {
        return longueurCombinaison;
    }

    public void setLongueurCombinaison(int longueurCombinaison) {
        this.longueurCombinaison = longueurCombinaison;
    }

    public int getNombreChiffresDifferents() {
        return nombreChiffresDifferents;
    }

    public void setNombreChiffresDifferents(int nombreChiffresDifferents) {
        this.nombreChiffresDifferents = nombreChiffresDifferents;
    }
}
