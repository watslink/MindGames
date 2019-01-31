package com.sd.MindGames.games;


import com.sd.MindGames.utils.ReadProperties;

public class MastermindGame extends Game {

    private int valeurMalPlacee = 0;
    private boolean valeurMalPlaceeTrouvee;

    public MastermindGame() {
        super();
        nombreChiffresDifferents = ReadProperties.readIntFromProperties("nombreChiffresDifferents");
    }

    @Override
    public void afficherRegles() {
        System.out.println();
        System.out.println("***************************");
        System.out.println("****** Jeu MasterMind *****");
        System.out.println("***************************");
        System.out.println("  La combinaison secrete ");
        System.out.println("         comporte        ");
        System.out.println("         " + getLongueurCombinaison() + " chiffres!");
        System.out.println("         de  valeur                ");
        System.out.println("          0 à " + (getNombreChiffresDifferents() - 1));
        System.out.println("***************************");
        System.out.println();
    }

    @Override
    public String comparerCombinaisons(int[] combinaisonSecrete, int[] reponseProposee) {
        reponseString = "Réponse : ";
        valeurOk = 0;
        valeurMalPlacee = 0;

        for (int i = 0; i < longueurCombinaison; i++) {
            valeurMalPlaceeTrouvee = false;
            if (combinaisonSecrete[i] == reponseProposee[i]) {
                valeurOk++;
            } else {
                for (int j = 0; !valeurMalPlaceeTrouvee && j < longueurCombinaison; j++) {
                    if (combinaisonSecrete[j] == reponseProposee[i]) {
                        valeurMalPlacee++;
                        valeurMalPlaceeTrouvee = true;
                    }
                }
            }
        }


        if (valeurOk == longueurCombinaison) {
            return getVICTOIRE();
        } else {
            switch (valeurMalPlacee) {
                case 0:
                    break;
                case 1:
                    reponseString += valeurMalPlacee + " présent, ";
                    break;
                default:
                    reponseString += valeurMalPlacee + " présents, ";
                    break;
            }
            switch (valeurOk) {
                case 0:
                    break;
                case 1:
                    reponseString += valeurOk + " bien placé";
                    break;
                default:
                    reponseString += valeurOk + " bien placés";
                    break;
            }
            return reponseString;
        }
    }
}
