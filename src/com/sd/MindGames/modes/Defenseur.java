package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.Player;

public class Defenseur extends Mode {

    Player player;
    public Defenseur(Game game){

        super(game);
        player= new Player();
        start();
    }

    @Override
    public void start() {

        System.out.println("Veuillez entrer une combinaison Mystère: ");
        int [] response=convertStringToTabOfInt(sc.nextLine());
        if(response!=null){
            if(checkFormatOfResponse(response)) {
                player.setCombinaisonSecrete(response);
            }
            else
                System.out.println("Erreur dans la saisie");
        }
        else
            System.out.println("Erreur dans la saisie");
    }


}
