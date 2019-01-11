package com.sd.MindGames.games;

import com.sd.MindGames.utils.ReadProperties;

public class RechercheGame extends Game {

    public RechercheGame(){
        super();
        setLongueurCombinaison(ReadProperties.readIntFromProperties("longeurCombinaison"));
        setNombreChiffresDifferents(10);
    }


    @Override
    protected String compareCombinaisons(int[] combinaisonSecrete, int[] reponse) {
        return null;
    }


}
