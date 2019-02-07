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

    /**
     * methode de lancement du mode
     */
    public abstract void start();

    /**
     * acquisition de la combinaison secrète du joueur
     */
    protected void setPlayerCombinaisonSecrete() {
        System.out.println("Veuillez entrer une combinaison secrète: ");
        joueur.setCombinaisonSecrete(AcquisitionEtVerificationCombinaison());
    }

    /**
     * acquisition de la combinaison secrète du bot
     */
    protected void setBotPlayerCombinaisonSecrete() {
        ordinateur.setCombinaisonSecrete(ordinateur.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
    }


    /**
     * acquisition de la reponse proposée du joueur
     */
    protected void setPlayerReponseProposee() {
        System.out.println("Votre proposition: ");

        joueur.setReponseProposee(AcquisitionEtVerificationCombinaison());

    }

    /**
     * acquisition de la reponse proposée du bot
     */
    protected void setBotPlayerReponseProposee() {
        ordinateur.setReponseProposee(ordinateur.creerCombinaisonAleatoire(game.getLongueurCombinaison(), game.getNombreChiffresDifferents()));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Proposition du Bot: " + Arrays.toString(ordinateur.getReponseProposee()));
    }

    /**
     * controle de la reponse proposee par rapport à la combinaison secrète
     * @param defenseur
     * @param attaquant
     */
    protected void checkPlayerReponseProposee(Player defenseur, Player attaquant) {
        String str = game.comparerCombinaisons(defenseur.getCombinaisonSecrete(), attaquant.getReponseProposee());

        if (str.equals(Game.getVICTOIRE())) {
            win = true;
            System.out.println(attaquant.getNom()+ " a " + str);
        } else
            System.out.println(str);
    }

    /**
     * acquisition et verification du format de la combinaison proposée
     * @return
     */
    private int[] AcquisitionEtVerificationCombinaison() {

        while (true) {
            int[] combiProposee = convertirStringEnTabInt(sc.nextLine());
            if (!checkLongeurReponseProposee(combiProposee))
                System.out.println("Erreur dans la saisie, Recommencez:");
            else {

                return combiProposee;
            }
        }
    }

    /**
     * converttion d'un String en tableau de Int
     * @param str
     * @return
     */
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
     *Verification de la longeueur de la combinaison proposée
     * @param combinaisonProposee
     * @return
     */
    protected boolean checkLongeurReponseProposee(int[] combinaisonProposee) {
        if (combinaisonProposee==null) {
            return false;
        }
        if (combinaisonProposee.length != game.getLongueurCombinaison()){
            return false;
        }
        for (int i = 0; i < combinaisonProposee.length; i++) {
            if (combinaisonProposee[i] > (game.getNombreChiffresDifferents() - 1))
                return false;
        }
        return true;
    }

    /**
     * si le mode developpement est activé, affichage de la combinaison secrète du bot
     */
    protected void afficherCombinaisonSecreteSiDevMode() {
        if (Config.isDevMode() ) {
            System.out.println("Combinaison secrete :" + Arrays.toString(ordinateur.getCombinaisonSecrete()));
        }
    }
}

