package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;

import java.util.Scanner;

public class Challenger extends Mode {

    BotPlayer bot;


    public Challenger(Game game){
        super(game);
        bot= new BotPlayer();

    }

    @Override
    public void start() {

        bot.createCombinaisonSecreteAleatoire(getGame().getLongueurCombinaison(), getGame().getNombreChiffresDifferents());

        System.out.println("Proposition: ");




    }



}
