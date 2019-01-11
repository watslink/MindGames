package com.sd.MindGames.games;

import com.sd.MindGames.modes.Mode;
import com.sd.MindGames.utils.ReadProperties;

public abstract class AbstractGame {


    private int[] reponse;

    public AbstractGame(){

    }



    protected abstract String compareCombinaisons(int[] combinaisonSecrete, int[] reponse);


}
