package com.sd.MindGames.games;


import com.sd.MindGames.utils.ReadProperties;

public class MastermindGame extends AbstractGame {


    public MastermindGame(){
        super();
        setLongueurCombinaison(ReadProperties.readIntFromProperties("longeurCombinaison"));
        setNombreChiffresDifferents(ReadProperties.readIntFromProperties("nombreChiffresDifferents"));
    }


    @Override
    protected String compareCombinaisons(int[] combinaisonSecrete, int[] reponse) {
        return null;
    }


}
