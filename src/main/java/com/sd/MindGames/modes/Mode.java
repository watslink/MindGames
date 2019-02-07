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
    protected Player joueur;
    protected BotPlayer ordinateur;


    public Mode(Game newGame) {
        game = newGame;
        joueur = new Player("Joueur");
        ordinateur = new BotPlayer("Ordinateur");
        game.afficherRegles();

    }

    public abstract void start();

    protected void setPlayerCombinaisonSecrete() {
        System.out.println("Veuillez entrer une combinaison secrète: ");
        joueur.setCombinaisonSecrete(AquisitionEtVerificationCombinaison());
    }

    protected void setBotPlayerCombinaisonSecrete() {
        ordinateur.setCombinaisonSecrete(ordinateur.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
    }

    protected void setPlayerReponseProposee() {
        System.out.println("Votre proposition: ");

        joueur.setReponseProposee(AquisitionEtVerificationCombinaison());

    }

    protected void setBotPlayerReponseProposee() {
        ordinateur.setReponseProposee(ordinateur.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));

        System.out.println("Proposition du Bot: " + Arrays.toString(ordinateur.getReponseProposee()));
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

    /**
     *
     * @param reponseProposee
     * @return
     */
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
            System.out.println("Combinaison secrete :" + Arrays.toString(ordinateur.getCombinaisonSecrete()));
        }
    }
}

