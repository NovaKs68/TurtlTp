package com.company.Game;

import java.util.*;
import java.lang.*;
import java.io.InputStreamReader;
import com.company.Game.Grille;
import com.company.model.Bank;
import com.company.model.Player;
import com.company.model.Position;

/**
 * Va servir d'interface homme machine
 */
public class Plateau {

    Grille grille;

    Player player = Player.getInstance();

    Bank bank = Bank.getInstance();

    public Plateau() {
        // Scanner for read input value
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu Memory revisité !");
        System.out.print("Entrez le nombre de colonne que fera votre grille : ");
        int grilleWidth = scanner.nextInt();
        System.out.print("Entrez le nombre de ligne que fera votre grille : ");
        int grilleHeight = scanner.nextInt();

        grille = new Grille(grilleWidth, grilleHeight);

        boolean gameFail = false;

        while(!gameFail) {

            Position actualPosition = grille.getActualPosition();
            System.out.println("Position : [" + actualPosition.getX() + "] [" + actualPosition.getY() + "]");

            StringBuilder displayRedPawn = new StringBuilder("Pions rouges : [");

            int numberOfRedPawn = player.getRedPawn();
            int limitedNumberOfRedPawn = player.getLimitedRedPawn();
            for (int i = 0; i < limitedNumberOfRedPawn; i++) {
                if (numberOfRedPawn > 0) {
                    displayRedPawn.append(" R,");
                    numberOfRedPawn--;
                } else {
                    displayRedPawn.append(" .,");
                }
            }
            displayRedPawn.delete(displayRedPawn.length() - 1, displayRedPawn.length());
            displayRedPawn.append("]");
            System.out.println(displayRedPawn);

            System.out.print("Poser (p/P), Ramasser (r/R), Avancer (a/A) ou Quitter (q/Q) ? ");
            String command = scanner.nextLine();

            switch (command) {
                case "p":
                case "P":
                    // Todo : Fonction drop
                    // grille.poser();
                    break;
                case "r":
                case "R":
                    // Todo : Fonction take
                    // grille.ramaser();
                    break;
                case "a":
                case "A":
                    Dice dice = new Dice();
                    int randomNumber = dice.diceRoll();
                    // Todo : Fonction moveForward
                    grille.moveForward(randomNumber);

                    System.out.println("Dé = " + randomNumber);
                    break;
                case "q":
                case "Q":
                    gameFail = true;
                    break;
                default:
                    System.out.println("Vous avez fait une faute de frappe !");
            }
        }
    }


}
