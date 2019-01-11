package com.sd.MindGames.games;

import com.sd.MindGames.utils.ReadProperties;

public class MastermindGame extends AbstractGame {


    public MastermindGame(){
        load();
    }

    @Override
    public void load() {
        super.load();
        int nb=ReadProperties.readIntFromProperties("nombreEssais");
        System.out.println("MasterMind!!!!"+ nb);
    }
}
