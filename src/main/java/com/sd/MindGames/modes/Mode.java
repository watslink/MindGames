package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;
import com.sd.MindGames.player.Player;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Mode {

    protected Game game;
    protected Scanner sc = new Scanner(System.in);
    protected boolean win;
    protected Player player;
    protected BotPlayer bot;

    public Mode (Game newGame){
        game=newGame;
        player=new Player();
        bot=new BotPlayer();
        game.getIntroduction();
        start();
    }

    public abstract void start();

    public void setPlayerCombinaisonSecrete(){
        System.out.println("Veuillez entrer une combinaison secrète: ");
        boolean combiOk=false;
        while(!combiOk) {
            player.setCombinaisonSecrete(convertStringToTabOfInt(sc.nextLine()));

            if (!checkFormatOfResponse(player.getCombinaisonSecrete()))
                System.out.println("Erreur dans la saisie");
            else combiOk=true;
        }


    }

    public void setBotPlayerCombinaisonSecrete(){
        bot.setCombinaisonSecrete(bot.createCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
    }

    public void setAndCheckBotPlayerReponseProposee(){
        bot.setReponseProposee(bot.createCombinaisonAleatoire(game.getLongueurCombinaison(),game.getNombreChiffresDifferents()));

        System.out.println("Proposition du Bot: " + Arrays.toString(bot.getReponseProposee()));

        String str = game.compareCombinaisons(bot.getReponseProposee(), player.getCombinaisonSecrete());

        if(str.equals(Game.getVICTORY())){
            win=true;
            System.out.println("L'ordinateur a "+str);
        }
        else
            System.out.println(str);

    }
    public boolean setAndCheckPlayerReponseProposee(){
        System.out.println("Votre proposition: ");

        player.setReponseProposee(convertStringToTabOfInt(sc.nextLine()));
        if(player.getReponseProposee()!=null){
            if(checkFormatOfResponse(player.getReponseProposee())) {
                String str=game.compareCombinaisons(bot.getCombinaisonSecrete(), player.getReponseProposee());

                if(str.equals(Game.getVICTORY())){
                    win=true;
                    System.out.println("Vous avez "+str);
                }
                else
                    System.out.println(str);

                return true;
            }
            else
                System.out.println("Erreur dans la saisie");
                return false;
        }

        else
            System.out.println("Erreur dans la saisie");
            return false;
    }

    public int[] convertStringToTabOfInt(String str){
        int[] tab;

        try{
            tab = new int[str.length()];
            for ( int i=0; i<str.length(); i++) {
                tab[i] = Integer.parseInt("" + str.charAt(i));
            }
            return tab;
        }
        catch (NumberFormatException e){
            return tab=null;
        }

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

