package com.sd.MindGames.player;

public class Player {

    private int[] combinaisonSecrete = null;
    private int[] reponseProposee = null;


    public Player() {
    }

    public int[] getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    public void setCombinaisonSecrete(int[] combinaisonSecrete) {
        this.combinaisonSecrete = combinaisonSecrete;
    }

    public int[] getReponseProposee() {
        return reponseProposee;
    }

    public void setReponseProposee(int[] reponseProposee) {
        this.reponseProposee = reponseProposee;
    }
}
