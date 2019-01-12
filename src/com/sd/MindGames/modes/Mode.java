package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;

import java.util.Scanner;

public abstract class Mode {

    protected Game game;
    protected Scanner sc = new Scanner(System.in);
    protected boolean win;

    public Mode (Game newGame){
        game=newGame;
    }

    public abstract void start();


    public int[] convertStringToTabOfInt(String str){

        int[] tab = new int[str.length()];
        for ( int i=0; i<str.length(); i++) {
            tab[i] = Integer.parseInt("" + str.charAt(i));
        }
            return tab;
    }

    public boolean checkFormatOfResponse(int[] response){
        if(response.length != game.getLongueurCombinaison()){
           return false;
        }


        for (int i=0; i<response.length; i++)
        {
            if(response[i]>(game.getNombreChiffresDifferents()-1))
                return false;
        }

        return true;
    }
}

