package com.sd.MindGames.games;

import com.sd.MindGames.utils.ReadProperties;

public abstract class AbstractGame {

    private int[] combinaisonSecrete;
    private int[] reponse;

    public AbstractGame(){
        combinaisonSecrete=new int[ReadProperties.readIntFromProperties("longueurCombinaison")];
        reponse=new int[ReadProperties.readIntFromProperties("longueurCombinaison")];
        setCombinaisonSecrete();
    }

    protected abstract int setCombinaisonSecrete();

    protected abstract String setReponse();


}
