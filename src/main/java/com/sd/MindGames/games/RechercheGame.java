package com.sd.MindGames.games;


public class RechercheGame extends Game {

    public RechercheGame(){
        super();
        nombreChiffresDifferents=10;
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
            if(valeurOk==longueurCombinaison){
                return getVICTORY();
            }
            else{
                return responseString;
            }
    }


}
