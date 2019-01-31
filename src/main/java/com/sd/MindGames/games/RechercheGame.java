package com.sd.MindGames.games;


public class RechercheGame extends Game {

    public RechercheGame() {
        super();
        nombreChiffresDifferents = 10;
    }

    @Override
    public void afficherRegles() {
        System.out.println();
        System.out.println("***************************");
        System.out.println("** Jeu Recherche + ou - **");
        System.out.println("***************************");
        System.out.println(" La combinaison secrete ");
        System.out.println("         comporte        ");
        System.out.println("        " + getLongueurCombinaison() + " chiffres!");
        System.out.println("***************************");
        System.out.println();
    }

    @Override
    public String comparerCombinaisons(int[] combinaisonSecrete, int[] reponseProposee) {
        reponseString = "Réponse : ";
        valeurOk = 0;

        for (int i = 0; i < longueurCombinaison; i++) {
            if (combinaisonSecrete[i] == reponseProposee[i]) {
                reponseString = reponseString + "=";
                valeurOk++;
            }
            if (combinaisonSecrete[i] < reponseProposee[i]) {
                reponseString = reponseString + "-";
            }
            if (combinaisonSecrete[i] > reponseProposee[i]) {
                reponseString = reponseString + "+";
            }
        }

        nombreEssaisActuel++;

        if (valeurOk == longueurCombinaison) {
            nombreEssaisActuel = 0;
            return getVICTOIRE();
        } else {
            return reponseString;
        }
    }
}
