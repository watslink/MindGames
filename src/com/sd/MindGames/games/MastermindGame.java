package com.sd.MindGames.games;

public class MastermindGame extends AbstractGame {


    public MastermindGame(){
        load();
    }

    @Override
    public void load() {
        super.load();
        System.out.println("MasterMind!!!!");
    }
}
