package com.sd.MindGames.games;


import com.sd.MindGames.utils.ReadProperties;

public class MastermindGame extends Game {


    public MastermindGame(){
        super();
        nombreChiffresDifferents=ReadProperties.readIntFromProperties("nombreChiffresDifferents");
    }


    @Override
    public String compareCombinaisons(int[] combinaisonSecrete, int[] reponse) {
        return null;
    }


}
