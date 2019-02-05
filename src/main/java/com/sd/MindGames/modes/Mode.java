package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;
import com.sd.MindGames.player.Player;
import com.sd.MindGames.utils.Config;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Mode {

    protected Game game;
    protected Scanner sc = new Scanner(System.in);
    protected boolean win;
    protected Player player;
    protected BotPlayer bot;


    public Mode(Game newGame) {
        game = newGame;
        player = new Player("Joueur");
        bot = new BotPlayer("Ordinateur");
        game.afficherRegles();

    }

    public abstract void start();

    protected void setPlayerCombinaisonSecrete() {
        System.out.println("Veuillez entrer une combinaison secrète: ");
        player.setCombinaisonSecrete(AquisitionEtVerificationCombinaison());
    }

    protected void setBotPlayerCombinaisonSecrete() {
        bot.setCombinaisonSecrete(bot.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
    }

    protected void setPlayerReponseProposee() {
        System.out.println("Votre proposition: ");

        player.setReponseProposee(AquisitionEtVerificationCombinaison());

    }

    protected void setBotPlayerReponseProposee() {
        bot.setReponseProposee(bot.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));

        System.out.println("Proposition du Bot: " + Arrays.toString(bot.getReponseProposee()));
    }

    protected void checkPlayerReponseProposee(Player defenseur, Player attaquant) {
        String str = game.comparerCombinaisons(defenseur.getCombinaisonSecrete(), attaquant.getReponseProposee());

        if (str.equals(Game.getVICTOIRE())) {
            win = true;
            System.out.println(attaquant.getNom()+ " a " + str);
        } else
            System.out.println(str);
    }


    private int[] AquisitionEtVerificationCombinaison() {

        while (true) {
            int[] combiProposee = convertirStringEnTabInt(sc.nextLine());
            if (!checkLongeurReponseProposee(combiProposee))
                System.out.println("Erreur dans la saisie, Recommencez:");
            else {

                return combiProposee;
            }
        }
    }

    protected int[] convertirStringEnTabInt(String str) {
        int[] tab;

        try {
            tab = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                tab[i] = Integer.parseInt("" + str.charAt(i));
            }
            return tab;
        } catch (NumberFormatException e) {
            return tab = null;
        }
    }

    protected boolean checkLongeurReponseProposee(int[] reponseProposee) {
        if (reponseProposee==null) {
            return false;
        }
        if (reponseProposee.length != game.getLongueurCombinaison()){
            return false;
        }
        for (int i = 0; i < reponseProposee.length; i++) {
            if (reponseProposee[i] > (game.getNombreChiffresDifferents() - 1))
                return false;
        }
        return true;
    }

    protected void afficherCombinaisonSecreteSiDevMode() {
        if (Config.isDevMode() ) {
            System.out.println("Combinaison secrete :" + Arrays.toString(bot.getCombinaisonSecrete()));
        }
    }
}

