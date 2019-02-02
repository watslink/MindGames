package com.sd.MindGames.modes;

import com.sd.MindGames.games.Game;
import com.sd.MindGames.player.BotPlayer;
import com.sd.MindGames.player.Player;
import com.sd.MindGames.utils.ReadProperties;

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
        player = new Player();
        bot = new BotPlayer();
        game.afficherRegles();

    }

    public abstract void start();

    protected void setPlayerCombinaisonSecrete() {
        System.out.println("Veuillez entrer une combinaison secrète: ");
        player.setCombinaisonSecrete(AquisitionEtVerificationCombinaison());
    }

    protected void setBotPlayerCombinaisonSecrete() {
        bot.setCombinaisonSecrete(bot.createCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
    }

    protected void setPlayerReponseProposee() {
        System.out.println("Votre proposition: ");

        player.setReponseProposee(AquisitionEtVerificationCombinaison());

    }

    protected void setBotReponseProposee() {
        bot.setReponseProposee(bot.createCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));

        System.out.println("Proposition du Bot: " + Arrays.toString(bot.getReponseProposee()));
    }

    protected void checkPlayerReponseProposee() {
        String str = game.comparerCombinaisons(bot.getCombinaisonSecrete(), player.getReponseProposee());

        if (str.equals(Game.getVICTOIRE())) {
            win = true;
            System.out.println("Vous avez " + str);
        } else
            System.out.println(str);
    }

    protected void checkBotReponseProposee() {

        String str = game.comparerCombinaisons(player.getCombinaisonSecrete(), bot.getReponseProposee());

        if (str.equals(Game.getVICTOIRE())) {
            win = true;
            System.out.println("L'ordinateur a " + str);
        } else
            System.out.println(str);
    }

    private int[] AquisitionEtVerificationCombinaison() {

        while (true) {
            int[] combiProposee = convertStringToTabOfInt(sc.nextLine());
            if (!checkFormatOfResponse(combiProposee))
                System.out.println("Erreur dans la saisie, Recommencez:");
            else {

                return combiProposee;
            }
        }
    }

    protected int[] convertStringToTabOfInt(String str) {
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

    protected boolean checkFormatOfResponse(int[] reponseProposee) {
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
        if (ReadProperties.readBooleanFromProperties("devMode")) {
            System.out.println("Combinaison secrete :" + Arrays.toString(bot.getCombinaisonSecrete()));
        }
    }
}

