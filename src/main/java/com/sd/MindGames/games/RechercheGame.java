package com.sd.MindGames.games;


public class RechercheGame extends Game {

    public RechercheGame(){
        super();
        nombreChiffresDifferents=10;
    }

    @Override
    public void getIntroduction() {
        System.out.println("");
        System.out.println("***************************");
        System.out.println("** Jeu Recherche + ou - **");
        System.out.println("***************************");
        System.out.println(" La combinaison secrete ");
        System.out.println("         comporte        ");
        System.out.println("        "+getLongueurCombinaison()+" chiffres!");
        System.out.println("***************************");
        System.out.println("");
    }

    @Override
    public String compareCombinaisons(int[] combinaisonSecrete, int[] response) {
        responseString="Réponse : ";
        valeurOk=0;

        for(int i=0; i<longueurCombinaison;i++)
        {
            if (combinaisonSecrete[i]==response[i]) {
                responseString=responseString+"=";
                valeurOk++;
            }
            if (combinaisonSecrete[i]<response[i]) {responseString=responseString+"-";}
            if (combinaisonSecrete[i]>response[i]) {responseString=responseString+"+";}


        }

        nombreEssaisActuel++;

        if(valeurOk==longueurCombinaison){
            nombreEssaisActuel=0;
            return getVictory();
        }

        else{
            return responseString;
        }
    }


}
