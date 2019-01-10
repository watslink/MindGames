package com.sd.MindGames;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("**************************");
        System.out.println("**Bienvenue à MindGames!**");
        System.out.println("**************************");
        System.out.println("");
        System.out.println("Listes des jeux:");
        System.out.println("Recherche + ou - : 1");
        System.out.println("MasterMind : 2");
        System.out.println("Votre choix?");

        int nb = sc.nextInt();
        if (nb != 1 && nb != 2 && nb != 3)

        switch (nb) {
            case 1:

                break;
            case 2:

                break;
        }
    }
}
