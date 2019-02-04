package com.sd.MindGames.games;

import com.sd.MindGames.utils.PropertiesUtils;

public abstract class Game {


    protected int longueurCombinaison;
    protected int nombreEssaisMax;
    protected int nombreEssaisActuel;
    protected int nombreChiffresDifferents;
    protected String reponseString;
    protected int valeurOk;
    protected static String VICTOIRE = "gagné!!";


    public Game() {
        longueurCombinaison = PropertiesUtils.readIntFromProperties("longueurCombinaison");
        nombreEssaisMax = PropertiesUtils.readIntFromProperties("nombreEssais");
        nombreEssaisActuel = 0;
    }

    public abstract void afficherRegles();

    public abstract String comparerCombinaisons(int[] combinaisonSecrete, int[] reponseProposee);

    public int getLongueurCombinaison() {
        return longueurCombinaison;
    }

    public int getNombreEssais() {
        return nombreEssaisMax;
    }

    public int getNombreChiffresDifferents() {
        return nombreChiffresDifferents;
    }

    public static String getVICTOIRE() {
        return VICTOIRE;
    }


}
