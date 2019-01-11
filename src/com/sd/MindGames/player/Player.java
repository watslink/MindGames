package com.sd.MindGames.player;

import com.sd.MindGames.utils.ReadProperties;

public class Player {

    private int[] combinaisonSecrete;

    public Player(){
        combinaisonSecrete=new int[ReadProperties.readIntFromProperties("longueurCombinaison")];
    }

    public void setCombinaisonSecrete(int[] combinaison){
      combinaisonSecrete=combinaison  ;
    }

}
